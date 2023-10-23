package com.staygrateful.mbkmsample

import com.google.gson.annotations.SerializedName

data class LoginResponse(
	val data: Data? = null,
	val status: Boolean? = null
)

data class Data(
	@SerializedName("refresh_token")
	val refreshToken: String? = null,
	val expiresAt: String? = null,
	val token: String? = null
)

