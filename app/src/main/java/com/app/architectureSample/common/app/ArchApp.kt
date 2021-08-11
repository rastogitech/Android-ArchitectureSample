package com.app.architectureSample.common.app

import android.app.Application
import com.app.architectureSample.common.dependencyInjection.AppInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class ArchApp : Application(), HasAndroidInjector {

    companion object {
        lateinit var instance: ArchApp
    }

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        instance = this

        AppInjector.init(this)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }

}