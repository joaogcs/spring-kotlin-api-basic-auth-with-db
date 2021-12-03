package com.example.springkotlinuserauthpostgresql.usecases.ports

import com.example.springkotlinuserauthpostgresql.domains.User

interface UserRepositoryPort {

    fun getNumberOfUsers(): Int
    fun findAll(): List<User>
    fun findUserByEmail(email: String): User
}