package com.example.weatherappcompose.data.datasource.remote.entity

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.time.Instant
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

data class WeatherApiResponse(
    val now_dt: String,
    val info: Info,
    @SerializedName("geo_object")
    val geoObject: GeoObject,
    val fact: Fact,
    val forecasts: List<Forecast>
)