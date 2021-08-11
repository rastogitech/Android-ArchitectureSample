package com.app.architectureSample.data.user.remote

import com.app.architectureSample.common.network.NetworkException
import com.app.architectureSample.common.network.NetworkResponse
import com.app.architectureSample.common.network.Result
import com.app.architectureSample.data.user.remote.model.LoginRequest
import com.app.architectureSample.data.user.remote.model.LoginResponse
import retrofit2.Response
import javax.inject.Inject

class UserRemoteDataSourceImpl @Inject constructor(
    val userAPI: UserAPI
) : UserRemoteDataSource {

    override suspend fun doLogin(loginRequest: LoginRequest): Result<LoginResponse> {
        val retrofitResponse: Response<LoginResponse?> = userAPI.doLogin(loginRequest)

        val networkResult = NetworkResponse(
            retrofitResponse.body(),
            retrofitResponse.code(),
            retrofitResponse.headers()
        )

        return if (retrofitResponse.isSuccessful) {
            Result.Success(networkResult)
        } else {
            val networkException =
                NetworkException("Something went wrong.", retrofitResponse.code())
            Result.Error(networkException)
        }
    }
}