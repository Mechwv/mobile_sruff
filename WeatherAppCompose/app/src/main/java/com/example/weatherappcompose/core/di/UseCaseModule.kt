package com.example.weatherappcompose.core.di

import com.example.weatherappcompose.data.repository.WeatherRepositoryImpl
import com.example.weatherappcompose.data.usecase.GetWeaterUseCaseImpl
import com.example.weatherappcompose.domain.repository.WeatherRepository
import com.example.weatherappcompose.domain.usecase.weather.GetWeatherUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Singleton
    @Binds
    abstract fun bindGetWeatherUsecase(
        useCase: GetWeaterUseCaseImpl
    ): GetWeatherUseCase
}