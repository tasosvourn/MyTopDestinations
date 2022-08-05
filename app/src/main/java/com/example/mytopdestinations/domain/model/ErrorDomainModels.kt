package com.example.mytopdestinations.domain.model

data class ErrorDomainModel(val errorType: DomainErrorType, val errorMessage: String? = null) {
    fun getAsDomainError(): DomainResult.Error = DomainResult.Error(this)
}

sealed class DomainErrorType

data class UnknownErrorType(val message: String = "") : DomainErrorType()

fun UnknownErrorType.newErrorDomainModel() = ErrorDomainModel(this, this.message)

data class ApiErrorType(
    val errorCode: String? = null,
    val errorType: Int? = null
) : DomainErrorType()

data class HTTPErrorType(
    val errorCode: Int? = null,
    val errorMessage: String?
) : DomainErrorType()

data class NetworkExceptionType(
    val exception: Exception? = null,
    val errorMessage: String?
) : DomainErrorType()

object EmptyListErrorType : DomainErrorType()