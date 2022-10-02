package com.example.weatherappcompose.core.di

import com.example.weatherappcompose.data.datasource.CoroutineDispatcherProvider
import com.example.weatherappcompose.data.repository.WeatherRepositoryImpl
import com.example.weatherappcompose.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindWeatherRepository(
        weatherRepositoryImpl: WeatherRepositoryImpl
    ): WeatherRepository

//    @Binds
//    abstract fun bindDispatcher(
//        coroutineDispatcherProvider: CoroutineDispatcherProvider
//    ): CoroutineDispatcherProvider
}