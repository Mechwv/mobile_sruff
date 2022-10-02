package com.example.weatherappcompose.data.repository

import com.example.weatherappcompose.data.datasource.remote.api.YandexWeatherApiService
import com.example.weatherappcompose.data.datasource.remote.entity.WeatherApiResponse
import com.example.weatherappcompose.domain.repository.WeatherRepository
import retrofit2.Response
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val service: YandexWeatherApiService
): WeatherRepository {
    override suspend fun getWeather(
        lat: Double,
        long: Double,
        limit: Int
    ): Response<WeatherApiResponse> {
        val apiWeather = service.getWeather(
            lat = lat,
            long = long,
            limit = limit,
        )
//        return apiWeather.t
    }
}