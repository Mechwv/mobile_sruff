package com.example.weatherappcompose.ui.screens.home

import android.Manifest
import android.annotation.SuppressLint
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.NavHostController
import com.example.weatherappcompose.ui.screens.home.view.*
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState

@Suppress("KotlinConstantConditions")
@Composable
fun HomeScreen(
    navController: NavHostController,
    padding: PaddingValues,
    setFabOnClick: (() -> Unit) -> Unit,
    viewModel: HomeViewModel = hiltViewModel(),

    ) {
    LaunchedEffect(Unit) {
        setFabOnClick { viewModel.fetchWeather() }
    }

    val viewState by viewModel.state.collectAsState()



    Surface(
        modifier = Modifier
            .padding(padding)
            .padding(10.dp, 0.dp)
    ) {
        SinglePermission()

        viewState.weatherLocation?.let {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(6.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                item(span = { GridItemSpan(maxLineSpan) }) {
                    MainTemperatureComponent(
                        tempValue = it.fact.temp.toDouble(),
                        feelsLike = it.fact.feels_like,
                        weatherInfo = map(it.fact.condition).replaceFirstChar {
                            it.uppercase()
                        },
                        icon = it.fact.icon
                    )
                }
//                item(span = { GridItemSpan(maxLineSpan) }) { HourlyCard(hoursInfo = it.hours) }
                item(span = { GridItemSpan(maxLineSpan) }) { DailyCard(it.forecasts) }
                item { HumidityCard(humidity = it.fact.humidity.toDouble()) }
                item { PressureCard(visibility = it.fact.pressure_mm) }
                item { UvIndexCard(uvIndex = it.fact.uv_index.toDouble()) }
                item { WindCard(windSpeed = it.fact.wind_speed) }
                item { Spacer(modifier = Modifier.size(6.dp)) }
            }
        }
    }
}

fun map(source: String): String {
    return when (source) {
        "clear" -> "ясно"
        "partly-cloudy" -> "малооблачно"
        "cloudy" -> "облачно с прояснениями"
        "overcast" -> "пасмурно"
        "drizzle" -> "морось"
        "light-rain" -> "небольшой дождь"
        "rain" -> "дождь"
        "moderate-rain" -> "умеренно сильный дождь"
        "heavy-rain" -> "сильный дождь"
        "continuous-heavy-rain" -> "длительный сильный дождь"
        "showers" -> "ливень"
        "wet-snow" -> "дождь со снегом"
        "light-snow" -> "небольшой снег"
        "snow" -> "снег"
        "snow-showers" -> "снегопад"
        "hail" -> "град"
        "thunderstorm" -> "гроза"
        "thunderstorm-with-rain" -> "дождь с грозой"
        "thunderstorm-with-hail" -> "гроза с градом"
        else -> "rofl"
    }
}

@SuppressLint("PermissionLaunchedDuringComposition")
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun SinglePermission(){

    val permissionState =
        rememberPermissionState(permission = Manifest.permission.ACCESS_COARSE_LOCATION)
    val lifecycleOwner = LocalLifecycleOwner.current

    DisposableEffect(key1 = lifecycleOwner, effect = {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_START -> {
                    permissionState.launchPermissionRequest()
                }
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    })

    when {
        permissionState.hasPermission -> {
            Text(text = "Location permission is granted")
        }
        permissionState.shouldShowRationale -> {
            Column {
                Text(text = "Location permission is required by this app")
            }
        }
        !permissionState.hasPermission && !permissionState.shouldShowRationale -> {
            Text(text = "Permission fully denied. Go to settings to enable")
        }
    }


}




