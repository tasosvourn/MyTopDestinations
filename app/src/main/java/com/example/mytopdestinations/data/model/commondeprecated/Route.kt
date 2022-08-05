package com.example.mytopdestinations.data.model.commondeprecated

import com.google.gson.annotations.SerializedName

data class Route (

	@SerializedName("id") val id : String,
	@SerializedName("flyFrom") val flyFrom : String,
	@SerializedName("flyTo") val flyTo : String,
	@SerializedName("cityFrom") val cityFrom : String,
	@SerializedName("cityCodeFrom") val cityCodeFrom : String,
	@SerializedName("cityTo") val cityTo : String,
	@SerializedName("cityCodeTo") val cityCodeTo : String,
	@SerializedName("mapIdfrom") val mapIdFrom : String,
	@SerializedName("mapIdto") val mapIdTo : String,
	@SerializedName("latFrom") val latFrom : Double,
	@SerializedName("lngFrom") val lngFrom : Double,
	@SerializedName("latTo") val latTo : Double,
	@SerializedName("lngTo") val lngTo : Double,
	@SerializedName("dTime") val dTime : Int,
	@SerializedName("dTimeUTC") val dTimeUTC : Int,
	@SerializedName("aTime") val aTime : Int,
	@SerializedName("aTimeUTC") val aTimeUTC : Int,
	@SerializedName("vehicle_type") val vehicle_type : String,
	@SerializedName("airline") val airline : String,
	@SerializedName("flight_no") val flight_no : Int,
	@SerializedName("operating_carrier") val operating_carrier : String,
	@SerializedName("operating_flight_no") val operating_flight_no : String,
	@SerializedName("equipment") val equipment : String,
	@SerializedName("fare_basis") val fare_basis : String,
	@SerializedName("fare_category") val fare_category : String,
	@SerializedName("fare_family") val fare_family : String,
	@SerializedName("fare_classes") val fare_classes : String,
	@SerializedName("return") val ret_urn : Int,
	@SerializedName("bags_recheck_required") val bags_recheck_required : Boolean,
	@SerializedName("guarantee") val guarantee : Boolean,
	@SerializedName("vi_connection") val vi_connection : Boolean
)