package com.example.weatherappcompose.domain.usecase.weather

import com.example.weatherappcompose.data.datasource.remote.entity.WeatherApiResponse
import com.example.weatherappcompose.domain.repository.Resource

interface GetWeatherUseCase {
    suspend operator fun invoke(
        lat: Double,
        long: Double,
        limit: Int
    ): Resource<WeatherApiResponse>
}