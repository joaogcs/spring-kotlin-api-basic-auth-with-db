package com.example.springkotlinuserauthsqldatasource.domains.exceptions

class NotFoundException(
    override val message: String?
) : RuntimeException(message)