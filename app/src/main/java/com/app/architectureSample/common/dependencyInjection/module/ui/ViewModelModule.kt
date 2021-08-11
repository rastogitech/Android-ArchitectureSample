package com.app.architectureSample.common.dependencyInjection.module.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.architectureSample.common.dependencyInjection.AppViewModelFactory
import com.app.architectureSample.common.dependencyInjection.ViewModelKey
import com.app.architectureSample.ui.onboarding.login.LoginViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindUserViewModel(loginViewModel: LoginViewModel): ViewModel
}
