package com.app.architectureSample.common.dependencyInjection.module.ui

import com.app.architectureSample.ui.onboarding.login.LoginActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun bindLoginActivity(): LoginActivity
}