package com.example.weatherappcompose.data.datasource.remote.entity

import com.example.weatherappcompose.domain.model.Fact
import com.example.weatherappcompose.domain.model.Forecast

data class ForecastApi(
    val date: String,
    val sunrise: String,
    val sunset: String,
    val rise_begin: String,
    val set_end: String,
    val parts: WeatherTimeApi
)

fun ForecastApi.toModel(): Forecast {
    return Forecast(
        date = this.date,
        parts = parts.toModel()
    )
}