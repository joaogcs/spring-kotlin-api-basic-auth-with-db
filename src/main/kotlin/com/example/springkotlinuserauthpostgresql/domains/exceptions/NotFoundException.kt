package com.example.springkotlinuserauthpostgresql.domains.exceptions

class NotFoundException(
    override val message: String?
) : RuntimeException(message) {
}