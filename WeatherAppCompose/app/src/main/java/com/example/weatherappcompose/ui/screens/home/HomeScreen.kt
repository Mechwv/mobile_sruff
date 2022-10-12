package com.example.weatherappcompose.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.weatherappcompose.ui.screens.home.HomeViewModel
import com.example.weatherappcompose.ui.screens.home.view.*

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

        viewState.weatherLocation?.let {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(6.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                item(span = { GridItemSpan(maxLineSpan) }) {
                    MainTemperatureComponent(
                        tempValue = it.fact.temp.toDouble(),
                        tempMin = it.fact.temp.toDouble(),
                        tempMax = it.fact.temp.toDouble(),
                        weatherInfo = it.fact.condition,
                    )
                }
//                item(span = { GridItemSpan(maxLineSpan) }) { HourlyCard(hoursInfo = it.hours) }
                item(span = { GridItemSpan(maxLineSpan) }) { DailyCard(it.forecasts) }
                item { HumidityCard(humidity = it.fact.humidity.toDouble()) }
//                item { VisibilityCard(visibility = it.visibility) }
                item { UvIndexCard(uvIndex = it.fact.uv_index.toDouble()) }
                item { WindCard(windSpeed = it.fact.wind_speed) }
                item { Spacer(modifier = Modifier.size(6.dp)) }
            }
        } ?: run {

        }
    }


}
/*
@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        navController = rememberNavController(),
        null
    )
}*/



