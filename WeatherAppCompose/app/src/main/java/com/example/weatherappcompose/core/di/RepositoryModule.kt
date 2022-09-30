package com.example.weatherappcompose.core.di

import com.example.weatherappcompose.data.repository.WeatherRepositoryImpl
import com.example.weatherappcompose.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindWeatherService(
        weatherRepositoryImpl: WeatherRepositoryImpl
    ): WeatherRepository
}