package com.example.springkotlinuserauthpostgresql.gateways.repositories.postgresql.models

import com.example.springkotlinuserauthpostgresql.domains.User
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "users")
class UsersModel(
    @Id
    @Column(name = "username", nullable = false)
    val username: String,

    @Column(name = "email", nullable = false)
    val email: String,

    @Column(name = "password", nullable = false)
    private val password: String,

    @Column(name = "enabled", nullable = false)
    val enabled: Boolean = true,
) {

    fun toDomain(): User {
        return User(
            username = username,
            email = email,
            password = password,
            enabled = enabled
        )
    }

}