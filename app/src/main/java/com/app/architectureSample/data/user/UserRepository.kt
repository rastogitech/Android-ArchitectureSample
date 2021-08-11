package com.app.architectureSample.data.user

import com.app.architectureSample.common.dependencyInjection.qualifier.IODispatcher
import com.app.architectureSample.common.network.Result
import com.app.architectureSample.data.user.remote.UserRemoteDataSource
import com.app.architectureSample.data.user.remote.model.LoginRequest
import com.app.architectureSample.data.user.remote.model.LoginResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRepository @Inject constructor(
    val userRemoteRemoteDataSource: UserRemoteDataSource,
    @IODispatcher val coroutineDispatcher: CoroutineDispatcher
) {

    suspend fun doLogin(loginRequest: LoginRequest): Result<LoginResponse> {
        return withContext(coroutineDispatcher) {
            userRemoteRemoteDataSource.doLogin(loginRequest)
        }
    }
}