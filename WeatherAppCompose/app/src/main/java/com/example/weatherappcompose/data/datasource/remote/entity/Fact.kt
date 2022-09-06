package com.example.weatherappcompose.data.datasource.remote.entity

data class Fact(
    val temp: Int,
    val feels_like: Int,
    val icon: String,
    val condition: String,
    val cloudness: Int,
    val is_thunder: Boolean,
    val wind_speed: Int,
    val pressure_mm: Int,
    val humidity: Int,
    val uv_index: Int,
    val wind_gust: Double
)
