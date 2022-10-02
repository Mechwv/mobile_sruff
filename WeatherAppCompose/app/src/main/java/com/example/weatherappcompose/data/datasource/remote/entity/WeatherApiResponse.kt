package com.example.weatherappcompose.data.datasource.remote.entity

import com.example.weatherappcompose.domain.model.Weather
import com.google.gson.annotations.SerializedName

data class WeatherApiResponse(
    val now_dt: String,
    val info: InfoApi,
    @SerializedName("geo_object")
    val geoObjectApi: GeoObjectApi,
    @SerializedName("fact")
    val factApi: FactApi,
    @SerializedName("forecasts")
    val forecastApis: List<ForecastApi>
)

fun WeatherApiResponse.toModel(): Weather {
    return Weather(
        now_dt = this.now_dt,
        info = this.info.toModel(),
        geoObject = this.geoObjectApi.toModel(),
        fact = this.factApi.toModel(),
        forecasts = this.forecastApis.map { it.toModel() },
    )
}