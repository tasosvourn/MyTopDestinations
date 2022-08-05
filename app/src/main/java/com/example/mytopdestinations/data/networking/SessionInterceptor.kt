package com.example.mytopdestinations.data.networking

import okhttp3.Interceptor
import okhttp3.Response

class SessionInterceptor() :
    Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
            val builder = originalRequest.newBuilder()
            builder.addHeader("apikey", Headers.API_KEY)
            return chain.proceed(builder.build())
    }

    private fun constructCookie(sessionId: String) = "ASP.NET_SessionId=$sessionId;cmTPSet=Y"
}