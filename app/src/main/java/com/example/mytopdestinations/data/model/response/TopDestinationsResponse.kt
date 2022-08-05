package com.example.mytopdestinations.data.model.response

import com.example.mytopdestinations.data.model.response.common.Locations
import com.example.mytopdestinations.data.model.response.common.Meta
import com.google.gson.annotations.SerializedName

class TopDestinationsResponse : BaseResponse() {
    @SerializedName("locations")
    val locations: List<Locations>? = null
    @SerializedName("meta")
    val meta: Meta? = null
    @SerializedName("last_refresh")
    var lastRefresh: Int? = null
    @SerializedName("results_retrieved")
    var resultsRetrieved: Int? = null
}