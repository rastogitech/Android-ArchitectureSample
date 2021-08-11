package com.app.architectureSample.common.dependencyInjection.module

import com.app.architectureSample.data.user.remote.UserRemoteDataSource
import com.app.architectureSample.data.user.remote.UserRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [CoroutineModule::class])
class RepositoryModule {

    @Singleton
    @Provides
    fun providesUserDataSource(userRemoteDataSourceImpl: UserRemoteDataSourceImpl): UserRemoteDataSource {
        return userRemoteDataSourceImpl
    }
}