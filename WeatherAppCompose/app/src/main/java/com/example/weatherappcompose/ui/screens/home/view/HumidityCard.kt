package com.example.weatherappcompose.ui.screens.home.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.weatherappcompose.ui.components.CardHeader
import com.example.weatherappcompose.ui.components.CardType
import com.example.weatherappcompose.ui.components.CardView

@Composable
fun HumidityCard(
    humidity: Double,
    dewPoint: Double,
    modifier: Modifier = Modifier
) {
    CardView(modifier) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            CardHeader(cardType = CardType.HUMIDITY)
            Text(
                text = "$humidity%",
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = "Точка росы находится на температуре $dewPoint°С",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Preview
@Composable
fun HumidityCardPreview() {
    MaterialTheme {
        HumidityCard(24.0, 2.0)
    }
}