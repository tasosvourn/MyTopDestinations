package com.example.mytopdestinations.data.model.response.common

import com.google.gson.annotations.SerializedName

class Tags {

    @SerializedName("tag")
    var tag: String? = null

    @SerializedName("month_to")
    var monthTo: Int? = null

    @SerializedName("month_from")
    var monthFrom: Int? = null
}
