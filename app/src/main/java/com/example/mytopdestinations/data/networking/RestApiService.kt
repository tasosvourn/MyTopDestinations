package com.example.mytopdestinations.data.networking

import com.example.mytopdestinations.data.model.response.TopDestinationsResponse
import com.example.mytopdestinations.data.networking.Headers.API_KEY
import com.example.mytopdestinations.data.networking.Urls.LOCATIONS
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface RestApiService {

    @Headers("accept: application/json", "apikey: $API_KEY")
    @GET(LOCATIONS)
    suspend fun getTopDestinations(
        @Query("term") term: String,
        @Query("locale") locale: String,
        @Query("limit") limit: Int,
        @Query("sort") sort: String,
        @Query("active_only") activeOnly: String,
        @Query("source_popularity") sourcePopularity: String)
        : Response<TopDestinationsResponse>
}