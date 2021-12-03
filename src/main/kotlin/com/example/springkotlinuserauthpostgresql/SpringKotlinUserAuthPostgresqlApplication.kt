package com.example.springkotlinuserauthpostgresql

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity

@SpringBootApplication
class SpringKotlinUserAuthPostgresqlApplication

fun main(args: Array<String>) {
	runApplication<SpringKotlinUserAuthPostgresqlApplication>(*args)
}
