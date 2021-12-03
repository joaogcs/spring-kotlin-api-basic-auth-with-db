package com.example.springkotlinuserauthpostgresql.configs

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.security.SecurityRequirement
import io.swagger.v3.oas.models.security.SecurityScheme
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig(
) {
    companion object {
        const val SECURITY_REQUIREMENT = "Basic Auth"
    }

    @Bean
    fun customOpenAPI(): OpenAPI {
        return OpenAPI()
            .components(getComponents())
            .addSecurityItem(SecurityRequirement().addList(SECURITY_REQUIREMENT))
    }

    private fun getComponents(): Components? {
        val passwordFlowScheme = SecurityScheme()
            .type(SecurityScheme.Type.HTTP)
            .scheme("basic")
        return Components()
            .securitySchemes(mapOf(Pair(SECURITY_REQUIREMENT, passwordFlowScheme)))
    }
}