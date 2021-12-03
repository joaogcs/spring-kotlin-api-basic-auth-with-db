package com.example.springkotlinuserauthpostgresql.usecases

import com.example.springkotlinuserauthpostgresql.usecases.ports.UserRepositoryPort
import org.springframework.stereotype.Service

@Service
class GetNumberOfUsersUseCase(
    private val userRepositoryPort: UserRepositoryPort
) {

    fun count(): Int {
        return userRepositoryPort.getNumberOfUsers()
    }

}