package com.example.weatherappcompose.ui.screens.home.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt

@Composable
fun MainTemperatureComponent(
    tempValue: Double,
    tempMin: Double,
    tempMax: Double,
    weatherInfo: String,
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.surface
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "%d°".format(tempValue.roundToInt()),
                style = MaterialTheme.typography.headlineLarge,
                fontSize = 60.sp
            )
            Text(
                text = weatherInfo,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "Мин. %d° Макс. %d°".format(tempMin.roundToInt(), tempMax.roundToInt()),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Preview
@Composable
fun MainTemperatureComponentPreview() {
    MainTemperatureComponent(25.0, 21.0, 27.0, "Переменная облачноть")
}
