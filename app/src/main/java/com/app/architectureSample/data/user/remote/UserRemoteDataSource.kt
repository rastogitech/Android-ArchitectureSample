package com.app.architectureSample.data.user.remote

import com.app.architectureSample.common.network.Result
import com.app.architectureSample.data.user.remote.model.LoginRequest
import com.app.architectureSample.data.user.remote.model.LoginResponse

interface UserRemoteDataSource {

    suspend fun doLogin(loginRequest: LoginRequest): Result<LoginResponse>
}