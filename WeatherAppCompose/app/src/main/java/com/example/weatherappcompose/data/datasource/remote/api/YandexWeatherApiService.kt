package com.example.weatherappcompose.data.datasource.remote.api

import com.example.weatherappcompose.BuildConfig
import com.example.weatherappcompose.data.datasource.remote.entity.WeatherApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface YandexWeatherApiService {
    @Headers("X-Yandex-API-Key: ${BuildConfig.YANDEX_API_KEY}")
    @GET("forecast")
    suspend fun getWeather(
        @Query("lat") key: String,
        @Query("long") geocode: String,
        @Query("hours") hours: String = "false",
        @Query("extra") extra: String = "false"
    ): Response<WeatherApiResponse>
}