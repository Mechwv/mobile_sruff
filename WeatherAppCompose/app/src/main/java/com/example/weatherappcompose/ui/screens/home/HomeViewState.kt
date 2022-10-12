package com.example.weatherappcompose.ui.screens.home

import com.example.weatherappcompose.domain.model.Weather

data class HomeViewState(
    val isLoading: Boolean = false,
    val weatherLocation: Weather?
)

//TODO FIX THIS SHIT
