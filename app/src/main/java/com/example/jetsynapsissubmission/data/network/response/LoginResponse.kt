package com.example.jetsynapsissubmission.data.network.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("data")
	val data: DataResponse? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
)

data class DataResponse(

	@field:SerializedName("occupation_name")
	val occupationName: String? = null,

	@field:SerializedName("occupation_level")
	val occupationLevel: Int? = null
)
