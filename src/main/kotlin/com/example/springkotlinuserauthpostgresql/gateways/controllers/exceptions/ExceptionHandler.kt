package com.example.springkotlinuserauthpostgresql.gateways.controllers.exceptions

import com.example.springkotlinuserauthpostgresql.domains.exceptions.NotFoundException
import com.example.springkotlinuserauthpostgresql.gateways.controllers.dtos.ErrorResponseDto
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.security.access.AccessDeniedException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class ExceptionHandler {

    companion object {
        const val INTERNAL_ERROR_MESSAGE = "internal error"
        const val ACCESS_DENIED_ERROR_MESSAGE = "access is denied"
        const val UNEXPECTED_ERROR_MESSAGE = "unexpected error"
    }

    var logger: Logger =
        LoggerFactory.getLogger(this::class.java)

    @ExceptionHandler(RuntimeException::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleUnknownException(exception: RuntimeException, request: HttpServletRequest): ErrorResponseDto {
        val errorResponse = ErrorResponseDto(
            error = INTERNAL_ERROR_MESSAGE,
        )
        logger.error("${request.servletPath} throw $UNEXPECTED_ERROR_MESSAGE with message: ${exception.message}")
        return errorResponse
    }

    @ExceptionHandler(AccessDeniedException::class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    fun handleAccessDeniedException(exception: RuntimeException, request: HttpServletRequest){ /* Do nothing */ }

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFoundException(exception: RuntimeException, request: HttpServletRequest): ErrorResponseDto {
        return ErrorResponseDto(error = exception.message)
    }
}