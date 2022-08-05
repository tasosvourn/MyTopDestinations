package com.example.mytopdestinations.data.model.response.common

import com.google.gson.annotations.SerializedName

class Subdivision {
    @SerializedName("id")
    var id: String? = null
    @SerializedName("name")
    var name: String? = null
    @SerializedName("slug")
    var slug: String? = null
    @SerializedName("code")
    var code: String? = null
}
