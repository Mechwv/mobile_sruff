package com.example.weatherappcompose.data.datasource.remote.entity

data class Forecast(
    val date: String,
    val sunrise: String,
    val sunset: String,
    val rise_begin: String,
    val set_end: String,
    val parts: List<Part>
)