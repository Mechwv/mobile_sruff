package com.example.weatherappcompose.ui.screens.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import ru.mosit.weatherapp.domain.usecase.FetchWeatherByLocationUseCase
import ru.mosit.weatherapp.presentation.screens.home.HomeViewState
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchWeatherByLocationUseCase: FetchWeatherByLocationUseCase,
) : ViewModel() {

    //TODO FIX THIS SHIT

    private val _state = MutableStateFlow(HomeViewState(isLoading = false, weatherLocation = null))

    val state: StateFlow<HomeViewState>
        get() = _state

    fun fetchWeather() {
        viewModelScope.launch {
            fetchWeatherByLocationUseCase(55.757, 37.615)
                .flowOn(Dispatchers.Default)
                .onStart {
                    Log.d("HomeViewModel", "Start")
                    _state.value = HomeViewState(true, null)
                }
                .onCompletion { _state.value = HomeViewState(false, null) }
                .catch { exception ->
                    run {
                        Log.e("HomeViewModel", "catch", exception)
                        _state.value = HomeViewState(false, null)
                    }
                }
                .collect { weather -> _state.value = HomeViewState(false,weather) }
        }
        Log.d("HomeViewModel", "fetchWeather")
    }


}
