package com.example.weatherappcompose.ui.components

import com.example.weatherappcompose.R

enum class CardType(val title: Int, val icon: Int) {
    HUMIDITY(
        R.string.humidity,
        R.drawable.ic_humidity
    ),
    WIND(
        title = R.string.wind,
        icon = R.drawable.ic_wind
    ),
    VISIBILITY(
        title = R.string.visibility,
        icon = R.drawable.ic_visibility
    ),
    UV_INDEX(
        title = R.string.uv_index,
        icon = R.drawable.ic_uv_index
    ),
    HOURLY(
        title = R.string.hourly,
        icon = R.drawable.ic_hourly
    ),
    DAILY(
        title = R.string.weekly,
        icon = R.drawable.ic_daily
    )
}