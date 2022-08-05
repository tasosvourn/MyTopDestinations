package com.example.mytopdestinations.data.model.commondeprecated

import com.google.gson.annotations.SerializedName

data class CountryTo (

	@SerializedName("code") val code : String,
	@SerializedName("name") val name : String
)