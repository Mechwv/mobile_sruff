package com.example.weatherappcompose.ui.weather

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherappcompose.R
import com.example.weatherappcompose.data.datasource.CoroutineDispatcherProvider
import com.example.weatherappcompose.data.datasource.remote.entity.toModel
import com.example.weatherappcompose.domain.model.Weather
import com.example.weatherappcompose.domain.repository.Resource
import com.example.weatherappcompose.domain.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: WeatherRepository,
//    private val coroutineDispatcherProvider: CoroutineDispatcherProvider
) : ViewModel() {

    private var city: String = "Moscow"
    private val _uiState = MutableStateFlow<WeatherUiState>(WeatherUiState.Empty)
    val uiState: StateFlow<WeatherUiState> = _uiState

    init {
        // Calling this function in init{}
        // block so that it'll automatically
        // get called on initialization of viewmodel
        getWeather()
    }

    private fun getWeather() = viewModelScope.launch {
        //Post loading state
        _uiState.value = WeatherUiState.Loading

        val weather = repository.getWeather(
            lat = MOSCOW_LAT,
            long = MOSCOW_LONG,
            limit = 1
        )

        if (weather is Resource.Success) {
            _uiState.value = WeatherUiState.Loaded(
                weather.data!!.toModel()
            )
        } else {
            _uiState.value = WeatherUiState.Error(
               message = "Ошибка"
            )
        }
        // Posting success response
        // as it becomes ready

    }

    sealed class WeatherUiState {
        object Empty : WeatherUiState()
        object Loading : WeatherUiState()
        class Loaded(val data: Weather) : WeatherUiState()
        class Error(val message: String) : WeatherUiState()
    }

    companion object {
        const val MOSCOW_LONG = 37.618423
        const val MOSCOW_LAT = 55.751244
    }
}
