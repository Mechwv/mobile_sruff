package com.example.weatherappcompose.data.datasource.remote.entity

data class Part(
    val temp: Int,
    val wind_speed: Double,
    val wind_gust: Double,
    val pressure_mm: Int,
    val humidity: Int,
    val cloudness: Double,
    val icon: String,
    val condition: String,
    val uv_index: Int,
    val feels_like: Double
)
