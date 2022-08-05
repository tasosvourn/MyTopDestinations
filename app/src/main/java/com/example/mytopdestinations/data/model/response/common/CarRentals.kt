package com.example.mytopdestinations.data.model.response.common

import com.google.gson.annotations.SerializedName

class CarRentals {
    @SerializedName("provider_id")
    var providerId: Int? = null
    @SerializedName("providers_locations")
    var providersLocations: ArrayList<String>? = null
}
