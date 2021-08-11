package com.app.architectureSample.common.dependencyInjection.module

import com.app.architectureSample.common.dependencyInjection.qualifier.IODispatcher
import com.app.architectureSample.common.dependencyInjection.qualifier.MainDispatcher
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
class CoroutineModule {

    @Provides
    @IODispatcher
    fun providesIODispatcher(): CoroutineDispatcher {
        return Dispatchers.IO
    }

    @Provides
    @MainDispatcher
    fun providesMainDispatcher(): CoroutineDispatcher {
        return Dispatchers.Main
    }
}