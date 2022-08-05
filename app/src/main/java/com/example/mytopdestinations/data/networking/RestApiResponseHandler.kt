package com.example.mytopdestinations.data.networking

import com.example.mytopdestinations.data.model.response.BaseResponse
import com.example.mytopdestinations.domain.model.DomainResult
import com.example.mytopdestinations.domain.model.ErrorDomainModel
import com.example.mytopdestinations.domain.model.HTTPErrorType
import com.example.mytopdestinations.domain.model.NetworkExceptionType
import retrofit2.Response

/** Handle API responses. Wrapper to every api call.
 * @param K BaseResponse
 * @param T Generic Response
 * @param requestFunction
 * @return DomainResult
 * */
suspend fun <K: BaseResponse, T: Response<K>> handleApiResponse(requestFunction: suspend () -> T): DomainResult<K> {
    try{
        val response = requestFunction.invoke()

        if(response.isSuccessful) return DomainResult.Success(response.body()!!)
        else return DomainResult.Error(ErrorDomainModel(HTTPErrorType(response.code(), response.message())))
    } catch (exception: Exception) {
        val message = exception.message ?: ""
        return DomainResult.Error(
            ErrorDomainModel(
                NetworkExceptionType(
                    exception,
                    message.ifEmpty { exception.javaClass.name }
                )
            )
        )
    }
}