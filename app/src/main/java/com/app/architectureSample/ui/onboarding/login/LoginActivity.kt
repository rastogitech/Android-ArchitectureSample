package com.app.architectureSample.ui.onboarding.login

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.app.architectureSample.R
import com.app.architectureSample.databinding.LoginActivityBinding
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class LoginActivity : AppCompatActivity(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val loginViewModel by viewModels<LoginViewModel> { viewModelFactory }
    private lateinit var loginActivityBinding: LoginActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginActivityBinding = DataBindingUtil.setContentView(this, R.layout.login_activity)
        loginActivityBinding.loginViewModel = loginViewModel

        loginViewModel.onFloatingMessageDisplayEvent.observe(this, {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }
}