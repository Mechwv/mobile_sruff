package com.example.weatherappcompose.data.repository

import com.example.weatherappcompose.data.datasource.remote.api.YandexWeatherApiService
import com.example.weatherappcompose.data.datasource.remote.entity.WeatherApiResponse
import com.example.weatherappcompose.domain.repository.BaseRepo
import com.example.weatherappcompose.domain.repository.Resource
import com.example.weatherappcompose.domain.repository.WeatherRepository
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

class WeatherRepositoryImpl @Inject constructor(
    private val service: YandexWeatherApiService
): WeatherRepository, BaseRepo() {
    override suspend fun getWeather(
        lat: Double,
        long: Double,
        limit: Int
    ): Resource<WeatherApiResponse> {
        return safeApiCall {
            service.getWeather(
                lat = lat,
                long = long,
                limit = limit,
            )
        }
    }
}