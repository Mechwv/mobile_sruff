package com.example.weatherappcompose.data.datasource.remote.entity

import com.example.weatherappcompose.domain.model.Info

data class InfoApi(
    val lat: Double,
    val lon: Double,
)

fun InfoApi.toModel(): Info {
    return Info(
        lat = this.lat,
        lon = this.lon,
    )
}