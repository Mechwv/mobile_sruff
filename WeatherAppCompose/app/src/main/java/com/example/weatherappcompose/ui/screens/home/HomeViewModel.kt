package com.example.weatherappcompose.ui.screens.home

import android.app.Application
import android.location.Location
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherappcompose.data.datasource.remote.entity.toModel
import com.example.weatherappcompose.domain.repository.Resource
import com.example.weatherappcompose.domain.usecase.weather.GetWeatherUseCase
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val weatherUseCase: GetWeatherUseCase,
    application: Application
) : AndroidViewModel(application) {

    private val context by lazy { application.applicationContext }

    //TODO FIX THIS SHIT

    private val _state = MutableStateFlow(HomeViewState(isLoading = false, weatherLocation = null))

    val state: StateFlow<HomeViewState>
        get() = _state

    private lateinit var fusedLocationClient: FusedLocationProviderClient


    fun fetchWeather() {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)


        _state.value = HomeViewState(true, null)

        var currloc: Location? = null
        fusedLocationClient.lastLocation
            .addOnCompleteListener { task ->
                Log.e("TASK", task.result.toString())
                currloc = task.result
                viewModelScope.launch {
                    val weather = weatherUseCase(
                        lat = currloc?.latitude ?: ANTARCTICA_LAT,
                        long = currloc?.longitude ?: ANTARCTICA_LONG,
                        limit = 7
                    )

                    if (weather is Resource.Success) {
                        _state.value = HomeViewState(false, weather.data!!.toModel())
                    } else {
                        _state.value = HomeViewState(false, null)
                    }
                }
                Log.e("TASK_CURRLOC", currloc.toString())
            }
        Log.d("HomeViewModel", "fetchWeather")
    }

    companion object {
        const val MOSCOW_LONG = 37.618423
        const val ANTARCTICA_LAT = 75.0000
        const val MOSCOW_LAT = 55.751244
        const val ANTARCTICA_LONG = 0.000000
    }


}
