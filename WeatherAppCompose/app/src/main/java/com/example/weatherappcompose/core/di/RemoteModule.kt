package com.example.weatherappcompose.core.di

import com.example.weatherappcompose.data.datasource.remote.api.YandexWeatherApiService
import com.example.weatherappcompose.data.repository.WeatherRepositoryImpl
import com.example.weatherappcompose.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
abstract class RemoteModule {

//    @Binds
//    abstract fun bindAnalyticsService(
//        weatherRepositoryImpl: WeatherRepositoryImpl
//    ): WeatherRepository

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