package com.app.architectureSample.data.user.remote

import com.app.architectureSample.data.user.remote.model.LoginRequest
import com.app.architectureSample.data.user.remote.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserAPI {

    @POST("oauth/token")
    suspend fun doLogin(@Body loginRequest: LoginRequest): Response<LoginResponse?>
}