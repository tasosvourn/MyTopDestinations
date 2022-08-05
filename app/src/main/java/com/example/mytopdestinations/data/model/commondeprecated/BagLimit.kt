package com.example.mytopdestinations.data.model.commondeprecated

import com.google.gson.annotations.SerializedName

data class BagLimit (
	@SerializedName("hand_height") val hand_height : Int,
	@SerializedName("hand_length") val hand_length : Int,
	@SerializedName("hand_weight") val hand_weight : Int,
	@SerializedName("hand_width") val hand_width : Int,
	@SerializedName("hold_dimensions_sum") val hold_dimensions_sum : Int,
	@SerializedName("hold_height") val hold_height : Int,
	@SerializedName("hold_length") val hold_length : Int,
	@SerializedName("hold_weight") val hold_weight : Int,
	@SerializedName("hold_width") val hold_width : Int
)