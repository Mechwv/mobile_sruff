package com.example.weatherappcompose.domain.model

data class Weather(
    val now_dt: String = "",
    val info: Info,
    val geoObject: GeoObject,
    val fact: Fact = Fact(),
    val forecasts: List<Forecast>
)
