package com.example.weatherappcompose.domain.model

data class Fact(
    val temp: Int = 0,
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
