package ru.mosit.weatherapp.presentation.screens.home

import ru.mosit.weatherapp.domain.model.WeatherLocationDto

data class HomeViewState(
    val isLoading: Boolean = false,
    val weatherLocation: WeatherLocationDto?
)

//TODO FIX THIS SHIT
