package com.example.mytopdestinations.data.mapper

import com.example.mytopdestinations.data.model.request.FetchTopDestinationsQuery

fun FetchTopDestinationsQuery.mapToQuery(): Map<String, Any> {
    val queryMap = HashMap<String, Any>()
    term
    locale
    limit
    sort
    activeOnly
    sourcePopularity
    fallbackPopularity
    return queryMap
}