package com.example.weatherappcompose.data.datasource.remote.entity

import com.example.weatherappcompose.domain.model.Fact
import com.example.weatherappcompose.domain.model.GeoObject

data class GeoObjectApi(
    val district: LocationItemApi,
    val locality: LocationItemApi,
    val province: LocationItemApi,
    val country: LocationItemApi,
)

fun GeoObjectApi.toModel(): GeoObject {
    return GeoObject(
        district = this.district.toModel(),
        locality= this.locality.toModel(),
        province= this.province.toModel(),
        country= this.country.toModel()
    )
}