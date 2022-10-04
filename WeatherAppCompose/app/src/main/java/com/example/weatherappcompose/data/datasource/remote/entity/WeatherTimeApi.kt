package com.example.weatherappcompose.data.datasource.remote.entity

import com.example.weatherappcompose.domain.model.WeatherTime

data class WeatherTimeApi(
    val morning: PartApi,
    val day: PartApi,
    val evening: PartApi,
    val night: PartApi,
    val night_short: PartApi,
    val day_short: PartApi,
)

fun WeatherTimeApi.toModel(): WeatherTime {
    return WeatherTime(
        day_short = this.day_short.toModel(),
        night_short = this.night_short.toModel(),
    )
}
