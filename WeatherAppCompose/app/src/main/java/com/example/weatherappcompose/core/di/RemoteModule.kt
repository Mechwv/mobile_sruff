package com.example.weatherappcompose.core.di

import com.example.weatherappcompose.data.datasource.remote.api.YandexWeatherApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteModule {

    @Provides
    @Singleton
    fun provideRetrofitService(
        // Potential dependencies of this type
    ): YandexWeatherApiService {
        return Retrofit.Builder()
            .baseUrl("https://api.weather.yandex.ru/v2/")
            .build()
            .create(YandexWeatherApiService::class.java)
    }
}