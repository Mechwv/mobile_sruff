package com.example.weatherappcompose.domain.model

data class GeoObject(
    val district: LocationItem,
    val locality: LocationItem,
    val province: LocationItem,
    val country: LocationItem,
)
