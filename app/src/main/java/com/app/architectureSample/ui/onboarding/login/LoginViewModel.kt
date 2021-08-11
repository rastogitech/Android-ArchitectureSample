package com.app.architectureSample.ui.onboarding.login

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.architectureSample.R
import com.app.architectureSample.common.network.Result
import com.app.architectureSample.common.ui.SingleLiveEvent
import com.app.architectureSample.data.user.UserRepository
import com.app.architectureSample.data.user.remote.model.LoginRequest
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    val application: Application,
    val userRepository: UserRepository
) : ViewModel() {

    val email = MutableLiveData<String?>()
    val password = MutableLiveData<String?>()

    val onFloatingMessageDisplayEvent = SingleLiveEvent<String>()

    fun onLoginClick() {
        val email = email.value?.trim()

        if (email.isNullOrBlank()) {
            onFloatingMessageDisplayEvent.value =
                application.getString(R.string.msg_enter_valid_email)
            return
        }

        val password = password.value?.trim()

        if (password.isNullOrBlank() || password.toString().trim().length < 8) {
            onFloatingMessageDisplayEvent.value =
                application.getString(R.string.msg_enter_valid_password)
        }

        val loginRequest = LoginRequest(
            "g9WZb3RlAObfuXkinxKiTqAJouZ7Uug6",
            "https://nhsdev.us.auth0.com/userinfo",
            "NHSOrg",
            "http://auth0.com/oauth/grant-type/password-realm",
            "openid profile email offline_access",
            email,
            password!!
        )

        viewModelScope.launch {
            doLogin(loginRequest)
        }
    }

    private suspend fun doLogin(loginRequest: LoginRequest) {
        when (val result = userRepository.doLogin(loginRequest)) {
            is Result.Success -> onFloatingMessageDisplayEvent.value = "Login success"
            is Result.Error -> onFloatingMessageDisplayEvent.value = result.networkException.message
        }
    }


}