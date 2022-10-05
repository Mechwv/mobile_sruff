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
import com.example.weatherappcompose.ui.components.CardHeader
import com.example.weatherappcompose.ui.components.CardType
import com.example.weatherappcompose.ui.components.CardView
import org.joda.time.DateTimeZone
import org.joda.time.Instant
import org.joda.time.format.DateTimeFormat
import ru.mosit.weatherapp.domain.model.WeatherDayDto
import ru.mosit.weatherapp.presentation.components.CardHeader
import ru.mosit.weatherapp.presentation.components.CardType
import ru.mosit.weatherapp.presentation.components.CardView
import java.util.*
import kotlin.math.roundToInt
import kotlin.math.roundToLong

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun DailyCard(
    daysInfo: List<WeatherDayDto>
) {

    //TODO FIX THIS SHIT
    val data = MutableList(5) { mutableListOf<Long>() }
    daysInfo.forEach { dayInfo ->
        data[0].add(dayInfo.dateTime)
        data[1].add(dayInfo.weatherIcons.staticIcon.toLong())
        data[2].add(dayInfo.temperature.roundToLong())
        data[3].add(dayInfo.minTemperature.roundToLong())
        data[4].add(dayInfo.maxTemperature.roundToLong())
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
//        LazyVerticalGrid(
//            columns = GridCells.Fixed(4)
//        ) {
        Column() {
            CardHeader(cardType = CardType.DAILY)
//            item(span = { GridItemSpan(maxLineSpan)} ){ CardHeader(cardType = CardType.DAILY) }
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceBetween
//            ) {
//                Column(
//                    horizontalAlignment = Alignment.Start
//                ) {
//                    data[0].forEach { date ->
//                        val dateStr = Instant.ofEpochSecond(date).toString(
//                            DateTimeFormat.forPattern("dd.MM")
//                                .withZone(DateTimeZone.forID("Europe/Moscow"))
//                        )
//
//                        Text(
//                            text = dateStr,
//                            style = mainTextStyle,
//                        )
//                    }
//                }
//
//                Column(
//                    horizontalAlignment = Alignment.Start
//                ) {
//                    data[1].forEach { iconId ->
//                        Icon(
//                            modifier = Modifier.size(30.dp),
//                            painter = painterResource(id = iconId.toInt()),
//                            tint = Color.Unspecified,
//                            contentDescription = null
//                        )
//                    }
//                }
//
//                Column(
//                    horizontalAlignment = Alignment.End
//                ) {
//                    data[2].forEach { temp ->
//                        Text(
//                            text = "${temp}°",
//                            style = mainTextStyle
//                        )
//                    }
//                }
//
//                Column(
//                    horizontalAlignment = Alignment.End,
//                    verticalArrangement = Arrangement.SpaceBetween,
//                    modifier = Modifier.fillMaxHeight()
//                ) {
//                    for (i in 0 until data[3].size) {
//                        Text(
//                            text = "Мин. ${data[3][i]} " +
//                                    "Макс. ${data[4][i]}",
//                            style = MaterialTheme.typography.bodyLarge
//                        )
//                    }
//                }
//            }
            daysInfo.forEach { dayInfo ->
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 0.dp, vertical = 5.dp)
                ) {

                    val dateInstant = Instant.ofEpochSecond(dayInfo.dateTime)
                    val dateStr = dateInstant.toString(dateTimeFormat)

                    Column() {
                        Text(
                            text = dateInstant.toString(wdTimeFormat),
                            style = mainTextStyle
                        )
                        Text(
                            text = dateStr,
                            style = mainTextStyle,
                        )
                    }

                    Column(
                        horizontalAlignment = Alignment.End
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "${dayInfo.temperature.roundToInt()}°",
                                style = mainTextStyle
                            )
                            Icon(
                                modifier = Modifier.size(30.dp),
                                painter = painterResource(id = dayInfo.weatherIcons.staticIcon),
                                tint = Color.Unspecified,
                                contentDescription = "${dateStr}Icon"
                            )
                        }

                        Text(
                                text = "Мин. ${dayInfo.minTemperature.roundToInt()} " +
                                        "Макс. ${dayInfo.maxTemperature.roundToInt()}",
                        style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }

//                items(daysInfo) { dayInfo ->
//                    val dateStr = Instant.ofEpochSecond(dayInfo.dateTime).toString(
//                        DateTimeFormat.forPattern("dd.MM")
//                            .withZone(DateTimeZone.forID("Europe/Moscow"))
//                    )
//
//                    Text(
//                        text = dateStr,
//                        style = mainTextStyle,
//                    )
//                    Icon(
//                        modifier = Modifier.size(30.dp),
//                        painter = painterResource(id = dayInfo.weatherIcons.staticIcon),
//                        tint = Color.Unspecified,
//                        contentDescription = "${dateStr}Icon"
//                    )
//                    Text(
//                        text = "${dayInfo.temperature.roundToInt()}°",
//                        style = mainTextStyle
//                    )
//                    Text(
//                        text = "Мин. ${dayInfo.minTemperature.roundToInt()} " +
//                                "Макс. ${dayInfo.maxTemperature.roundToInt()}",
//                        style = MaterialTheme.typography.bodyLarge
//                    )
//                }
//            }
        }
    }
}