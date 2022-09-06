package com.example.weatherappcompose.data.datasource.remote.entity

data class GeoObject(
    val district: LocationItem,
    val locality: LocationItem,
    val province: LocationItem,
    val country: LocationItem,
)
