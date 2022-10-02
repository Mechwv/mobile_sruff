package com.example.weatherappcompose.data.datasource.remote.entity

import com.example.weatherappcompose.domain.model.Fact

data class FactApi(
    val temp: Int,
    val feels_like: Int,
    val icon: String,
    val condition: String,
    val cloudness: Double,
    val is_thunder: Boolean,
    val wind_speed: Double,
    val pressure_mm: Int,
    val humidity: Int,
    val uv_index: Int,
    val wind_gust: Double
)

fun FactApi.toModel(): Fact {
    return Fact(
        temp = this.temp
    )
}

