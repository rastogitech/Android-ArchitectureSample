package com.app.architectureSample.common.dependencyInjection.module

import com.app.architectureSample.common.dependencyInjection.module.ui.ViewModelModule
import dagger.Module

@Module(
    includes = [
        ViewModelModule::class,
        NetworkModule::class,
        RepositoryModule::class]
)
class AppModule {


}