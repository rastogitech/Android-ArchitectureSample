package com.app.architectureSample.domain

import com.app.architectureSample.data.user.UserRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(val userRepository: UserRepository) {

    suspend fun invoke() {


    }
}