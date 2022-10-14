package com.example.weatherappcompose.ui.screens.home.view

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.SubcomposeAsyncImage
import coil.decode.SvgDecoder
import kotlin.math.roundToInt

@Composable
fun MainTemperatureComponent(
    tempValue: Double,
    feelsLike: Int,
    weatherInfo: String,
    icon: String
) {
    val imageLoader = ImageLoader.Builder(LocalContext.current)
        .components {
            add(SvgDecoder.Factory())
        }
        .build()

    Surface(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "%d°".format(tempValue.roundToInt()),
                    style = MaterialTheme.typography.headlineLarge,
                    fontSize = 60.sp
                )
//                Spacer(modifier = Modifier.weight(0.05f))
                SubcomposeAsyncImage(
                    model = "https://yastatic.net/weather/i/icons/funky/dark/${icon}.svg",
                    contentDescription = null,
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape),
                    loading = {
                        CircularProgressIndicator()
                    },
                    imageLoader = imageLoader
                )
            }

            Text(
                text = weatherInfo,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "Ощущается: $feelsLike°",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.alpha(0.5f),

            )
        }
    }
}

@Preview
@Composable
fun MainTemperatureComponentPreview() {
    MainTemperatureComponent(25.0, 21, "Переменная облачноть", "ssdf")
}
