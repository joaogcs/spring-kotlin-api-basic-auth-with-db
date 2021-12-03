package com.example.springkotlinuserauthpostgresql.domains

import javax.validation.constraints.NotBlank

data class User(
    @field:NotBlank
    val username: String,

    @field:NotBlank
    val email: String,

    @field:NotBlank
    private val password: String,

    @field:NotBlank
    val enabled: Boolean,
) {}