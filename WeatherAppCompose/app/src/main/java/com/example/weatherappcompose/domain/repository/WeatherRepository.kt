package com.example.weatherappcompose.domain.repository

import com.example.weatherappcompose.data.datasource.remote.entity.WeatherApiResponse
import retrofit2.Response

interface WeatherRepository {
    suspend fun getWeather(lat: Double, long: Double, limit: Int): Response<WeatherApiResponse>
}