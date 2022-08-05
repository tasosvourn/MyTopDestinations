package com.example.mytopdestinations.data.model.commondeprecated

import com.google.gson.annotations.SerializedName

data class Conversion (

	@SerializedName("EUR") val eUR : Int,
	@SerializedName("USD") val uSD : Int
)