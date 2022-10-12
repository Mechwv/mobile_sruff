package com.example.weatherappcompose.ui.screens.home.view

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherappcompose.domain.model.Forecast
import com.example.weatherappcompose.domain.model.Part
import com.example.weatherappcompose.ui.components.CardHeader
import com.example.weatherappcompose.ui.components.CardType
import com.example.weatherappcompose.ui.components.CardView
import org.joda.time.DateTimeZone
import org.joda.time.Instant
import org.joda.time.format.DateTimeFormat
import java.util.*
import kotlin.math.roundToInt
import kotlin.math.roundToLong

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun DailyCard(
    daysInfo: List<Forecast>
) {

    //TODO FIX THIS SHIT
    val data = MutableList(5) { mutableListOf<String>() }
    daysInfo.forEach { dayInfo ->
        data[0].add(dayInfo.date)
//        data[1].add(dayInfo.weatherIcons.staticIcon.toLong())
        data[1].add(dayInfo.parts.day_short.temp.toString())
        data[2].add(dayInfo.parts.night_short.temp.toString())
//        data[3].add(dayInfo. .roundToLong())
//        data[4].add(dayInfo.maxTemperature.roundToLong())
    }

    val mainTextStyle = MaterialTheme.typography.bodyLarge.copy(
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    )

    val locale = Locale("ru")
    val dateTimeZone = DateTimeZone.forID("Europe/Moscow")
    val wdTimeFormat = DateTimeFormat.forPattern("EEEE")
        .withZone(dateTimeZone)
        .withLocale(locale)
    val dateTimeFormat = DateTimeFormat.forPattern("dd MMM")
        .withZone(dateTimeZone)
        .withLocale(locale)

    CardView() {
        Column() {
            CardHeader(cardType = CardType.DAILY)

            daysInfo.forEach { dayInfo ->
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 0.dp, vertical = 5.dp)
                ) {

//                    val dateInstant = Instant.ofEpochSecond(dayInfo.dateTime)
//                    val dateStr = dateInstant.toString(dateTimeFormat)

//                    Column() {
//                        Text(
//                            text = dateInstant.toString(wdTimeFormat),
//                            style = mainTextStyle
//                        )
//                        Text(
//                            text = dateStr,
//                            style = mainTextStyle,
//                        )
//                    }

                    Column(
                        horizontalAlignment = Alignment.End
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "${dayInfo.date} ",
                                style = mainTextStyle
                            )
                            Text(
                                text = "Днем: ${dayInfo.parts.day_short.temp}°",
                                style = mainTextStyle
                            )
                            Text(
                                text = "Ночью: ${dayInfo.parts.day_short.temp}°",
                                style = mainTextStyle
                            )
//                            Icon(
//                                modifier = Modifier.size(30.dp),
//                                painter = painterResource(id = dayInfo.weatherIcons.staticIcon),
//                                tint = Color.Unspecified,
//                                contentDescription = "${dateStr}Icon"
//                            )
                        }

//                        Text(
//                                text = "Мин. ${dayInfo.minTemperature.roundToInt()} " +
//                                        "Макс. ${dayInfo.maxTemperature.roundToInt()}",
//                        style = MaterialTheme.typography.bodyLarge
//                        )
//                    }
                    }
                }
            }
        }
    }
}