package com.example.springkotlinuserauthsqldatasource.domains

data class User(
    val username: String,
    val email: String,
    val password: String? = null,
    val enabled: Boolean,
)