package com.example.springkotlinuserauthpostgresql.usecases

import com.example.springkotlinuserauthpostgresql.domains.User
import com.example.springkotlinuserauthpostgresql.usecases.ports.UserRepositoryPort
import org.springframework.stereotype.Service

@Service
class FindAllUsersUseCase(
    private val userRepositoryPort: UserRepositoryPort
) {

    fun find(): List<User> {
        return userRepositoryPort.findAll()
    }

}