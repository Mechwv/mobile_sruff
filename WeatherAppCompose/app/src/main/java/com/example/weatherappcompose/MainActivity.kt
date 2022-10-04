package com.example.weatherappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
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
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.res.painterResource
import androidx.compose.material.*


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
//            is MainViewModel.WeatherUiState.Error -> ErrorDialog(state.message)
//            is MainViewModel.WeatherUiState.Error -> AlertDialogSample()
            is MainViewModel.WeatherUiState.Loaded -> WeatherLoadedScreen(state.data)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WeatherLoadedScreen(data: Weather) {
    Text(
        text = data.geoObject.province.name,
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
            color = MaterialTheme.colors.secondary
        )
    )
    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(start = 12.dp)
    ) {
        items(items = data.forecasts, itemContent = { card ->
            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = card.date,
                    style = TextStyle(
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp
                    ),
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                )
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_day),
                        contentDescription = stringResource(R.string.day_temp),
                        tint = MaterialTheme.colors.secondary,
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .size(24.dp)
                    )
                    Text(
                        text = card.parts.day_short.temp.toString(),
                        style = TextStyle(
                            fontSize = 16.sp
                        ),
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                }
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_night),
                        contentDescription = stringResource(R.string.day_temp),
                        tint = MaterialTheme.colors.secondary,
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .size(24.dp)
                    )
                    Text(
                        text = card.parts.night_short.temp.toString(),
                        style = TextStyle(
                            fontSize = 16.sp
                        ),
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                }
                Divider()
            }
        })
    }
}

@Composable
fun ErrorDialog(messageId: Int) {
    val openDialog = remember { mutableStateOf(false) }
//    openDialog.value = true
    val message = stringResource(messageId)
    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                openDialog.value = false
            },
            title = {
                Text(text = "govno")
            },
            text = {
                Text("Zalupa mamonta")
            },
            confirmButton = {
                openDialog.value = false
            }
        )
    }
}

@Composable
fun AlertDialogSample() {
    MaterialTheme {
        Column {
            val openDialog = remember { mutableStateOf(false)  }

            Button(onClick = {
                openDialog.value = true
            }) {
                Text("Click me")
            }

            if (openDialog.value) {

                AlertDialog(
                    onDismissRequest = {
                        // Dismiss the dialog when the user clicks outside the dialog or on the back
                        // button. If you want to disable that functionality, simply use an empty
                        // onCloseRequest.
                        openDialog.value = false
                    },
                    title = {
                        Text(text = "Dialog Title")
                    },
                    text = {
                        Text("Here is a text ")
                    },
                    confirmButton = {
                        Button(

                            onClick = {
                                openDialog.value = false
                            }) {
                            Text("This is the Confirm Button")
                        }
                    },
                    dismissButton = {
                        Button(

                            onClick = {
                                openDialog.value = false
                            }) {
                            Text("This is the dismiss Button")
                        }
                    }
                )
            }
        }

    }
}