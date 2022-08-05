package com.example.mytopdestinations.data.model.response.common

import com.google.gson.annotations.SerializedName

class City {
    @SerializedName("id")
    var id: String? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("code")
    var code: String? = null

    @SerializedName("slug")
    var slug: String? = null

    @SerializedName("subdivision")
    var subdivision: String? = null

    @SerializedName("autonomous_territory")
    var autonomousTerritory: String? = null

    @SerializedName("country")
    var country: Country? = null

    @SerializedName("region")
    var region: Region? = null

    @SerializedName("continent")
    var continent: Continent? = null
}