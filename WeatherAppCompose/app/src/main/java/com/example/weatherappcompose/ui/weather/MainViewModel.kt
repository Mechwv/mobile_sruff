//package com.example.weatherappcompose.ui.weather
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.weatherappcompose.R
//import com.example.weatherappcompose.data.datasource.remote.entity.toModel
//import com.example.weatherappcompose.domain.model.Weather
//import com.example.weatherappcompose.domain.repository.Resource
//import com.example.weatherappcompose.domain.repository.WeatherRepository
//import com.example.weatherappcompose.domain.usecase.weather.GetWeatherUseCase
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.launch
//import javax.inject.Inject
//
//@HiltViewModel
//class MainViewModel @Inject constructor(
//    private val weatherUseCase: GetWeatherUseCase,
////    private val coroutineDispatcherProvider: CoroutineDispatcherProvider
//) : ViewModel() {
//
//    private var city: String = "Moscow"
//    private val _uiState = MutableStateFlow<WeatherUiState>(WeatherUiState.Empty)
//    val uiState: StateFlow<WeatherUiState> = _uiState
//
//    init {
//        // Calling this function in init{}
//        // block so that it'll automatically
//        // get called on initialization of viewmodel
//        getWeather()
//    }
//
//    private fun getWeather() = viewModelScope.launch {
//        //Post loading state
//        _uiState.value = WeatherUiState.Loading
//
//        val weather = weatherUseCase(
//            lat = MOSCOW_LAT,
//            long = MOSCOW_LONG,
//            limit = 1
//        )
//
//        if (weather is Resource.Success) {
//            _uiState.value = WeatherUiState.Loaded(
//                weather.data!!.toModel()
//            )
//        } else {
//            onErrorOccurred()
//        }
//        // Posting success response
//        // as it becomes ready
//
//    }
//
//    private fun onQueryLimitReached() {
//        _uiState.value = WeatherUiState.Error(
//            R.string.query_limit_reached
//        )
//    }
//
//    private fun onErrorOccurred() {
//        _uiState.value = WeatherUiState.Error(
//            R.string.something_went_wrong
//        )
//    }
//
//    sealed class WeatherUiState {
//        object Empty : WeatherUiState()
//        object Loading : WeatherUiState()
//        class Loaded(val data: Weather) : WeatherUiState()
//        class Error(val message: Int) : WeatherUiState()
//    }
//
//    companion object {
//        const val MOSCOW_LONG = 37.618423
//        const val MOSCOW_LAT = 55.751244
//    }
//}
