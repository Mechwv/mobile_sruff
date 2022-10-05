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
fun WindCard(
    windSpeed: Double,
    modifier: Modifier = Modifier
) {
    CardView(modifier){
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Column {
                CardHeader(cardType = CardType.WIND)
                Text(
                    text = "$windSpeed м/с",
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
    }
}

@Preview
@Composable
fun WindCardPreview() {
    WindCard(24.0)
}