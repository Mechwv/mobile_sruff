package com.example.weatherappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weatherappcompose.ui.theme.WeatherAppComposeTheme
import com.example.weatherappcompose.ui.weather.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.weatherappcompose.domain.model.Weather
import com.example.weatherappcompose.ui.theme.WeatherUiModel


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppComposeTheme {
                CurrentWeatherHeader()
            }
        }
    }
}

@Composable
@Preview
fun CurrentWeatherHeader(mainViewModel: MainViewModel = viewModel()){

//    Text(mainViewModel)
    val heightInPx = with(LocalDensity.current) { LocalConfiguration.current
        .screenHeightDp.dp.toPx()
    }
    Column(
        Modifier
            .background(
                Brush.verticalGradient(
                    listOf(Color.Transparent, Color.Gray, Color.Black),
                    0f,
                    heightInPx * 1.1f
                )
            )
    ) {
        when (val state = mainViewModel.uiState.collectAsState().value) {
            is MainViewModel.WeatherUiState.Empty -> Text(
                text = "Govnp",
                modifier = Modifier.padding(16.dp)
            )
            is MainViewModel.WeatherUiState.Loading ->
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                }
            is MainViewModel.WeatherUiState.Error -> ErrorDialog(state.message)
            is MainViewModel.WeatherUiState.Loaded -> WeatherLoadedScreen(state.data)
        }
    }
}

@Composable
fun WeatherLoadedScreen(data: Weather) {
    Text(
        text = data.info.toString(),
        modifier = Modifier
            .padding(start = 24.dp, top = 50.dp, end = 24.dp, bottom = 50.dp),
        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 24.sp)
    )
    Text(
        text = data.fact.temp.toString(),
        modifier = Modifier.padding(start = 24.dp, bottom = 100.dp),
        style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 50.sp,
            color = MaterialTheme.colorScheme.secondary
        )
    )
}

@Composable
fun ErrorDialog(message: String) {
    val openDialog = remember { mutableStateOf(true) }
    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                openDialog.value = false
            },
            title = {
                Text(text = "govno")
            },
            text = {
                Text(message)
            },
            confirmButton = {
                openDialog.value = false
            }
        )
    }
}