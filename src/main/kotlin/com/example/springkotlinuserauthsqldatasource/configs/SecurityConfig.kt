package com.example.springkotlinuserauthsqldatasource.configs

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.security.config.Customizer.withDefaults
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity.RequestMatcherConfigurer
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.JdbcUserDetailsManager
import org.springframework.security.provisioning.UserDetailsManager
import org.springframework.security.web.SecurityFilterChain
import javax.sql.DataSource
import javax.validation.constraints.NotBlank

@EnableWebSecurity
@ConfigurationProperties(prefix = "authorization")
data class SecurityConfig(
    val secure: List<SecurePathProperties>,
    val dataSource: DataSource,
) {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.requestMatchers { getAntMatchers(it) }
            .authorizeHttpRequests { getAntMatchers(it) }
            .httpBasic(withDefaults())
        return http.build()
    }

    @Bean
    fun users(dataSource: DataSource): UserDetailsManager {
        return JdbcUserDetailsManager(dataSource)
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    private fun getAntMatchers(requestMatcherConfigurer: RequestMatcherConfigurer): RequestMatcherConfigurer {
        secure.forEach {
            if (it.methods.contains("*")) requestMatcherConfigurer.antMatchers(it.path)
            else it.methods.forEach { method -> requestMatcherConfigurer.antMatchers(method, it.path) }
        }
        return requestMatcherConfigurer
    }

    private fun getAntMatchers(
        authorizeHttpRequestsConfigurer: AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry
    ): AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry {
        secure.forEach {
            if (it.methods.contains("*")) authorizeHttpRequestsConfigurer.antMatchers(it.path)
                .hasAnyRole(*it.roles.toTypedArray())
            else it.methods.forEach { method ->
                authorizeHttpRequestsConfigurer.antMatchers(method, it.path)
                    .hasAnyRole(*it.roles.toTypedArray())
            }
        }
        return authorizeHttpRequestsConfigurer
    }
}

class SecurePathProperties {
    @NotBlank
    lateinit var path: String
    var methods: List<String> = listOf("*")
    var roles: List<String> = listOf("ADMIN")
}