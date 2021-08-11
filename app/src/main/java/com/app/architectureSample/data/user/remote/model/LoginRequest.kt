package com.app.architectureSample.data.user.remote.model

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("client_id")
    val clientId: String,

    val audience: String,
    val realm: String,

    @SerializedName("grant_type")
    val grantType: String,
    val scope: String,
    val username: String,
    val password: String
)
