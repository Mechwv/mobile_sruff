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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        setFabOnClick {
            viewModel.fetchWeather()
        }
    }

    val viewState by viewModel.state.collectAsState()

    val mainTextStyle = MaterialTheme.typography.bodyLarge.copy(
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    )

    Surface(
        modifier = Modifier
            .padding(padding)
            .padding(10.dp, 0.dp)
    ) {
        viewState.weatherLocation?.let {

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(6.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                item(span = { GridItemSpan(maxLineSpan) }) {
                    Text(text = "${it.geoObject.locality.name} ", style = mainTextStyle)
                }
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
        "clear" -> "????????"
        "partly-cloudy" -> "??????????????????????"
        "cloudy" -> "?????????????? ?? ????????????????????????"
        "overcast" -> "????????????????"
        "drizzle" -> "????????????"
        "light-rain" -> "?????????????????? ??????????"
        "rain" -> "??????????"
        "moderate-rain" -> "???????????????? ?????????????? ??????????"
        "heavy-rain" -> "?????????????? ??????????"
        "continuous-heavy-rain" -> "???????????????????? ?????????????? ??????????"
        "showers" -> "????????????"
        "wet-snow" -> "?????????? ???? ????????????"
        "light-snow" -> "?????????????????? ????????"
        "snow" -> "????????"
        "snow-showers" -> "????????????????"
        "hail" -> "????????"
        "thunderstorm" -> "??????????"
        "thunderstorm-with-rain" -> "?????????? ?? ????????????"
        "thunderstorm-with-hail" -> "?????????? ?? ????????????"
        else -> "rofl"
    }
}




