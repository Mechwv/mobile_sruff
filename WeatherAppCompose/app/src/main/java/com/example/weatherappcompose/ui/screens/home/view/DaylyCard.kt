package com.example.weatherappcompose.ui.screens.home.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import coil.decode.SvgDecoder
import com.example.weatherappcompose.domain.model.Forecast
import com.example.weatherappcompose.ui.components.CardHeader
import com.example.weatherappcompose.ui.components.CardType
import com.example.weatherappcompose.ui.components.CardView
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.*

@OptIn(ExperimentalCoilApi::class)
@Composable
fun DailyCard(
    daysInfo: List<Forecast>
) {
    val mainTextStyle = MaterialTheme.typography.bodyLarge.copy(
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    )

    val imageLoader = ImageLoader.Builder(LocalContext.current)
        .components {
            add(SvgDecoder.Factory())
        }
        .build()

    CardView() {
        Column() {
            CardHeader(cardType = CardType.DAILY)


            daysInfo.forEach { dayInfo ->
                val date = LocalDate.parse(dayInfo.date)

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 0.dp, vertical = 5.dp)
                ) {
                    Column() {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {

                            Column(
                                verticalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "${
                                        date.dayOfWeek.getDisplayName(
                                            TextStyle.FULL,
                                            Locale("ru")
                                        )
                                    }",
                                    style = mainTextStyle
                                )
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        text = "${date.dayOfMonth} ",
                                        style = mainTextStyle
                                    )
                                    Text(
                                        text = "${
                                            date.month.getDisplayName(
                                                TextStyle.FULL,
                                                Locale("ru")
                                            )
                                        }",
                                        style = mainTextStyle
                                    )
                                }
                            }
                            Column(
                                verticalArrangement = Arrangement.SpaceBetween,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Row() {
                                    SubcomposeAsyncImage(
                                        model = "https://yastatic.net/weather/i/icons/funky/dark/${dayInfo.parts.day_short.icon}.svg",
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(24.dp)
                                            .clip(CircleShape),
                                        loading = {
                                            CircularProgressIndicator()
                                        },
                                        imageLoader = imageLoader
                                    )
                                    Text(
                                        text = "Днем: ${dayInfo.parts.day_short.temp}°",
                                        style = mainTextStyle
                                    )
                                }
                                Row() {
                                    SubcomposeAsyncImage(
                                        model = "https://yastatic.net/weather/i/icons/funky/dark/${dayInfo.parts.night_short.icon}.svg",
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(24.dp)
                                            .clip(CircleShape),
                                        loading = {
                                            CircularProgressIndicator()
                                        },
                                        imageLoader = imageLoader
                                    )
                                    Text(
                                        text = "Ночью: ${dayInfo.parts.night_short.temp}°",
                                        style = mainTextStyle
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}