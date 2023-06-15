package com.example.dogsapp.api

import com.google.gson.annotations.SerializedName

data class DogsResponse(

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: String
)
