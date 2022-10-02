package com.example.weatherappcompose.ui.weather

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.weatherappcompose.R
import com.example.weatherappcompose.data.datasource.CoroutineDispatcherProvider
import com.example.weatherappcompose.domain.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: WeatherRepository,
    private val coroutineDispatcherProvider: CoroutineDispatcherProvider
) : ViewModel() {

    private var city: String = "Moscow"
    private val _uiState = MutableStateFlow<WeatherUiState>(WeatherUiState.Empty)

}

sealed class WeatherUiState {
    object Empty : WeatherUiState()
    object Loading : WeatherUiState()
    class Loaded(val data: WeatherUiModel) : WeatherUiState()
    class Error(val message: String) : WeatherUiState()
}
