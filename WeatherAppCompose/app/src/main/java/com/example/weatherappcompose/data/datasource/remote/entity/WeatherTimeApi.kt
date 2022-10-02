package com.example.weatherappcompose.data.datasource.remote.entity

import com.example.weatherappcompose.domain.model.WeatherTime

data class WeatherTimeApi(
    val morning: PartApi,
    val day: PartApi,
    val evening: PartApi,
    val night: PartApi,
)

fun WeatherTimeApi.toModel(): WeatherTime {
    return WeatherTime(
        morning = this.morning.toModel(),
        day = this.day.toModel(),
        evening = this.evening.toModel(),
        night = this.night.toModel(),
    )
}
