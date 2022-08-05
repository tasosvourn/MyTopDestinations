package com.example.mytopdestinations.data.model.commondeprecated

import com.google.gson.annotations.SerializedName

data class Data (
	@SerializedName("id") val id : String,
	@SerializedName("flyFrom") val flyFrom : String,
	@SerializedName("flyTo") val flyTo : String,
	@SerializedName("cityFrom") val cityFrom : String,
	@SerializedName("cityCodeFrom") val cityCodeFrom : String,
	@SerializedName("cityTo") val cityTo : String,
	@SerializedName("cityCodeTo") val cityCodeTo : String,
	@SerializedName("countryFrom") val countryFrom : CountryFrom,
	@SerializedName("countryTo") val countryTo : CountryTo,
	@SerializedName("mapIdfrom") val mapIdFrom : String,
	@SerializedName("mapIdto") val mapIdTo : String,
	@SerializedName("dTime") val dTime : Int,
	@SerializedName("dTimeUTC") val dTimeUTC : Int,
	@SerializedName("aTime") val aTime : Int,
	@SerializedName("aTimeUTC") val aTimeUTC : Int,
	@SerializedName("bags_price") val bags_price : BagsPrice,
	@SerializedName("baglimit") val bagLimit : BagLimit,
	@SerializedName("price") val price : Int,
	@SerializedName("conversion") val conversion : Conversion,
	@SerializedName("fly_duration") val fly_duration : String,
	@SerializedName("duration") val duration : Duration,
	@SerializedName("nightsInDest") val nightsInDest : Int,
	@SerializedName("distance") val distance : Double,
	@SerializedName("virtual_interlining") val virtual_interlining : Boolean,
	@SerializedName("throw_away_ticketing") val throw_away_ticketing : Boolean,
	@SerializedName("hidden_city_ticketing") val hidden_city_ticketing : Boolean,
	@SerializedName("pnr_count") val pnr_count : Int,
	@SerializedName("has_airport_change") val has_airport_change : Boolean,
	@SerializedName("technical_stops") val technical_stops : Int,
	@SerializedName("booking_token") val booking_token : String,
	@SerializedName("deep_link") val deep_link : String,
	@SerializedName("route") val route : List<Route>
)