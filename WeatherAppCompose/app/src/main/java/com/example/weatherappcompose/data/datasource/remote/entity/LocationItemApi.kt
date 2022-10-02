package com.example.weatherappcompose.data.datasource.remote.entity

import com.example.weatherappcompose.domain.model.GeoObject
import com.example.weatherappcompose.domain.model.LocationItem

data class LocationItemApi(
    val name: String
)

fun LocationItemApi.toModel(): LocationItem {
    return LocationItem(
        name = this.name
    )
}
