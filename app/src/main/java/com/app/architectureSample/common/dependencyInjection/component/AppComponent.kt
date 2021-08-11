package com.app.architectureSample.common.dependencyInjection.component

import android.app.Application
import com.app.architectureSample.common.app.ArchApp
import com.app.architectureSample.common.dependencyInjection.module.AppModule
import com.app.architectureSample.common.dependencyInjection.module.ui.ActivityBindingModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityBindingModule::class,
        AppModule::class]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun application(application: Application): Builder
    }

    fun inject(archApp: ArchApp)
}