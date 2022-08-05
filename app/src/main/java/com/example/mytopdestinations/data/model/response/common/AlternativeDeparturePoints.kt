package com.example.mytopdestinations.data.model.response.common

import com.google.gson.annotations.SerializedName

class AlternativeDeparturePoints {
    @SerializedName("id")
    var id: String? = null
    @SerializedName("distance")
    var distance: Double? = null
    @SerializedName("duration")
    var duration: Double? = null
}
