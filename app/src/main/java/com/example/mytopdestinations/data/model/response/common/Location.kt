package com.example.mytopdestinations.data.model.response.common

import com.google.gson.annotations.SerializedName

class Location {

	@SerializedName("lon")
	var lon: Double? = null
	@SerializedName("lat")
	var lat: Double? = null
}