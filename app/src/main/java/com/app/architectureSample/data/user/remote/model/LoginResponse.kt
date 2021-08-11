package com.app.architectureSample.data.user.remote.model

import com.google.gson.annotations.SerializedName

class LoginResponse(
    @SerializedName("access_token")
    val accessToken: String,

    @SerializedName("refresh_token")
    val refreshToken: String,

    @SerializedName("id_token")
    val idToken: String,

    @SerializedName("expires_in")
    val expiresIn: Long,

    @SerializedName("token_type")
    val tokenType: String
)