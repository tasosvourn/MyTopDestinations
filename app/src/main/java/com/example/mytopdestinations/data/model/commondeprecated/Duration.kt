package com.example.mytopdestinations.data.model.commondeprecated

import com.google.gson.annotations.SerializedName

data class Duration (
	@SerializedName("departure") val departure : Int,
	@SerializedName("return") val ret_urn : Int,
	@SerializedName("total") val total : Int
)