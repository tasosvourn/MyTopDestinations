package com.example.mytopdestinations.data.model.response.common

import com.google.gson.annotations.SerializedName

class Locations {

    @SerializedName("id")
    var id: String? = null
    @SerializedName("active")
    var active: Boolean? = null
    @SerializedName("name")
    var name: String? = null
    @SerializedName("slug")
    var slug: String? = null
    @SerializedName("slug_en")
    var slugEn: String? = null
    @SerializedName("code")
    var code: String? = null
    @SerializedName("alternative_names")
    var alternativeNames: ArrayList<String>? = null
    @SerializedName("rank")
    var rank: Int? = null
    @SerializedName("global_rank_dst")
    var globalRankDst: Int? = null
    @SerializedName("dst_popularity_score")
    var dstPopularityScore: Int? = null
    @SerializedName("timezone")
    var timezone: String? = null
    @SerializedName("population")
    var population: Int? = null
    @SerializedName("airports")
    var airports: Int? = null
    @SerializedName("stations")
    var stations: Int? = null
    @SerializedName("hotels")
    var hotels: Int? = null
    @SerializedName("bus_stations")
    var busStations: Int? = null
    @SerializedName("subdivision")
    var subdivision: Subdivision? = null
    @SerializedName("autonomous_territory")
    var autonomousTerritory: String? = null
    @SerializedName("country")
    var country: Country? = null
    @SerializedName("region")
    var region: Region? = null
    @SerializedName("continent")
    var continent: Continent? = null
    @SerializedName("nearby_country")
    var nearbyCountry: String? = null
    @SerializedName("location")
    var location: Location? = null
    @SerializedName("tags")
    var tags: ArrayList<Tags>? = null
    @SerializedName("alternative_departure_points")
    var alternativeDeparturePoints: ArrayList<AlternativeDeparturePoints>? = null
    @SerializedName("providers")
    var providers: ArrayList<Int>? = null
    @SerializedName("car_rentals")
    var carRentals: ArrayList<CarRentals>? = null
    @SerializedName("type")
    var type: String? = null
}