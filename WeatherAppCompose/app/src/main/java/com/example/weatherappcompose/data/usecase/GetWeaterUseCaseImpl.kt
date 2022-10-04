package com.example.weatherappcompose.data.usecase

import com.example.weatherappcompose.data.datasource.remote.api.YandexWeatherApiService
import com.example.weatherappcompose.data.datasource.remote.entity.WeatherApiResponse
import com.example.weatherappcompose.domain.repository.Resource
import com.example.weatherappcompose.domain.repository.WeatherRepository
import com.example.weatherappcompose.domain.usecase.weather.GetWeatherUseCase
import javax.inject.Inject

class GetWeaterUseCaseImpl @Inject constructor(
    private val repository: WeatherRepository
) : GetWeatherUseCase{
    override suspend fun invoke(
        lat: Double,
        long: Double,
        limit: Int
    ): Resource<WeatherApiResponse> {
        return repository.getWeather(
            lat = lat,
            long = long,
            limit = limit
        )
    }
}