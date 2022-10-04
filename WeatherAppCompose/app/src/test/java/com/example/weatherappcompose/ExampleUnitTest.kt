package com.example.weatherappcompose

import com.example.weatherappcompose.data.datasource.remote.entity.WeatherApiResponse
import com.example.weatherappcompose.data.datasource.remote.entity.toModel
import com.example.weatherappcompose.domain.model.Weather
import com.google.gson.Gson

import org.junit.Assert.*
import org.junit.jupiter.api.Test
import java.io.File
import java.time.Instant
import java.util.*

class RandomUtilTests {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    @Test
    fun datetest(){
        val a = "2022-09-06T09:43:54.043602Z"
        val b = Instant.parse(a)
        println(Date.from(b))
    }

    @Test
    fun serialtestv2() {
        //since the tests can be read from JSON all large tests now should be in assets folder
        val testData = File("src/main/assets/testdata/v2testData.json").readText(Charsets.UTF_8)
        val k = Gson().fromJson(testData, WeatherApiResponse::class.java)
        println(k)
        println(testData)
    }

    @Test
    fun serialToModel(): Weather {
        //since the tests can be read from JSON all large tests now should be in assets folder
        val testData = File("src/main/assets/testdata/v2testData.json").readText(Charsets.UTF_8)
        val k = Gson().fromJson(testData, WeatherApiResponse::class.java)
        return k.toModel()
    }

    @Test
    fun forecastTemp() {
        val testData = File("src/main/assets/testdata/v2testData.json").readText(Charsets.UTF_8)
        val k = Gson().fromJson(testData, WeatherApiResponse::class.java).toModel().forecasts
        println(k)
    }
}