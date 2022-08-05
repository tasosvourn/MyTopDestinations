package com.example.mytopdestinations.data.networking

class EndPointConfiguration {
    private var baseUrl = "https://tequila-api.kiwi.com/"

    fun getBaseUrl(): String = baseUrl

    fun setBaseUrl(url: String) {
        baseUrl = url
    }
}
