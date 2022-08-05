package com.example.mytopdestinations.data.model.request

data class FetchTopDestinationsQuery(
    val term: String,
    val locale: String,
    val limit: Int,
    val sort: String,
    val activeOnly:String,
    val sourcePopularity: String,
    val fallbackPopularity: String
)
