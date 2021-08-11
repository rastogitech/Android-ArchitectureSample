package com.app.architectureSample.common.dependencyInjection.module

import com.app.architectureSample.data.user.remote.UserAPI
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://nhsdev.us.auth0.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesUserAPI(retrofit: Retrofit): UserAPI {
        return retrofit.create(UserAPI::class.java)
    }
}