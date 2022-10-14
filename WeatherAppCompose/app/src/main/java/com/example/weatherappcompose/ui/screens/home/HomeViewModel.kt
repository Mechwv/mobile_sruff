package com.example.weatherappcompose.ui.screens.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherappcompose.data.datasource.remote.entity.toModel
import com.example.weatherappcompose.domain.repository.Resource
import com.example.weatherappcompose.domain.usecase.weather.GetWeatherUseCase
import com.example.weatherappcompose.ui.weather.MainViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val weatherUseCase: GetWeatherUseCase,
) : ViewModel() {

    //TODO FIX THIS SHIT

    private val _state = MutableStateFlow(HomeViewState(isLoading = false, weatherLocation = null))

    val state: StateFlow<HomeViewState>
        get() = _state

    fun fetchWeather() {
        viewModelScope.launch {

            _state.value = HomeViewState(true, null)

            val weather = weatherUseCase(lat = MOSCOW_LAT, long = MOSCOW_LONG, limit = 7)

            if (weather is Resource.Success) {
                _state.value = HomeViewState(false, weather.data!!.toModel())
            } else {
                _state.value = HomeViewState(false, null)
            }
        }
        Log.d("HomeViewModel", "fetchWeather")
    }

    companion object {
        const val MOSCOW_LONG = 37.618423
        const val MOSCOW_LAT = 55.751244
    }


}
