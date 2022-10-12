package com.example.weatherappcompose.data.datasource.remote.entity

import com.example.weatherappcompose.domain.model.LocationItem
import com.example.weatherappcompose.domain.model.Part

data class PartApi(
    val temp: Int,
    val wind_speed: Double,
    val wind_gust: Double,
    val pressure_mm: Int,
    val humidity: Int,
    val cloudness: Double,
    val icon: String,
    val condition: String,
    val uv_index: Int,
    val feels_like: Double,
)

fun PartApi.toModel(): Part {
    return Part(
        temp = this.temp,
        wind_speed = this.wind_speed,
        wind_gust = this.wind_gust,
        pressure_mm = this.pressure_mm,
        humidity = this.humidity,
        cloudness = this.cloudness,
        icon = this.icon,
        condition = this.condition,
        uv_index = this.uv_index,
        feels_like = this.feels_like,
    )
}
