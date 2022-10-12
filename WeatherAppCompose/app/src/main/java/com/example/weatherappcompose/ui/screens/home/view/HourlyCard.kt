//package com.example.weatherappcompose.ui.screens.home.view
//
//import androidx.compose.foundation.horizontalScroll
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.material3.Icon
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.unit.dp
//import com.example.weatherappcompose.ui.components.CardHeader
//import com.example.weatherappcompose.ui.components.CardType
//import com.example.weatherappcompose.ui.components.CardView
//import org.joda.time.DateTimeZone
//import org.joda.time.Instant
//import org.joda.time.format.DateTimeFormat
//import ru.mosit.weatherapp.domain.model.WeatherHourDto
//import kotlin.math.roundToInt
//
//@Composable
//fun HourlyCard(
//    modifier: Modifier = Modifier,
//    hoursInfo: List<WeatherHourDto>
//) {
//    //TODO FIX THIS SHIT
//    CardView(modifier) {
//        Column() {
//            CardHeader(cardType = CardType.HOURLY)
//            Row(
//                modifier = Modifier.horizontalScroll(rememberScrollState())
//                    .padding(0.dp, 5.dp),
//                horizontalArrangement = Arrangement.spacedBy(10.dp)
//            ) {
//
//                hoursInfo.forEach { hourlyInfo ->
//                    val timeStr = Instant.ofEpochSecond(hourlyInfo.dateTime).toString(
//                        DateTimeFormat.forPattern("HH:mm")
//                            .withZone(DateTimeZone.forID("Europe/Moscow"))
//                    )
//
//                    Column(
//                        horizontalAlignment = Alignment.CenterHorizontally
//                    ) {
//                        Text(
//                            text = timeStr,
//                            style = MaterialTheme.typography.bodyMedium
//                        )
//                        Icon(
//                            modifier = Modifier.size(30.dp),
//                            painter = painterResource(id = hourlyInfo.weatherIcons.staticIcon),
//                            contentDescription = "${timeStr}Time",
//                            tint = Color.Unspecified,
//                        )
//                        Text(
//                            text = "${hourlyInfo.temperature.roundToInt()}°",
//                            style = MaterialTheme.typography.bodyLarge
//                        )
//                    }
//                }
//            }
//        }
//    }
//}