package com.example.springkotlinuserauthpostgresql.usecases

import com.example.springkotlinuserauthpostgresql.domains.User
import com.example.springkotlinuserauthpostgresql.usecases.ports.UserRepositoryPort
import org.springframework.stereotype.Service

@Service
class FindUserByEmailUseCase(
    private val userRepositoryPort: UserRepositoryPort
) {

    fun find(email: String): User {
        return userRepositoryPort.findUserByEmail(email)
    }

}