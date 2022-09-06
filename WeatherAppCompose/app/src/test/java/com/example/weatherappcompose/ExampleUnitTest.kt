package com.example.weatherappcompose

import com.example.weatherappcompose.data.datasource.remote.entity.WeatherApiResponse
import com.google.gson.Gson
import org.junit.Test

import org.junit.Assert.*
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
    fun serialtest() {
        val b = """
        {
            "now_dt": "2022-09-06T09:43:54.043602Z",
            "info": {
                "lat": 55.75396,
                "lon": 37.620393
            },
            "geo_object": {
                "district": {
                    "name": "Тверской район"
                },
                "locality": {
                    "name": "Москва"
                },
                "province": {
                    "name": "Москва"
                },
                "country": {
                    "name": "Россия"
                }
            },
            "fact": {
                "obs_time": 1662454800,
                "uptime": 1662457434,
                "temp": 10,
                "feels_like": 7,
                "icon": "ovc",
                "condition": "overcast",
                "cloudness": 1,
                "is_thunder": false,
                "wind_speed": 2,
                "pressure_mm": 751,
                "humidity": 65,
                "uv_index": 3,
                "wind_gust": 9.9
            },
            "forecasts": [
                {
                    "date": "2022-09-06",
                    "sunrise": "05:43",
                    "sunset": "19:12",
                    "rise_begin": "05:04",
                    "set_end": "19:51",
                    "parts": {
                        "morning": {
                            "_source": "6,7,8,9,10,11",
                            "temp_min": 7,
                            "temp_avg": 8,
                            "temp_max": 10,
                            "wind_speed": 4.6,
                            "wind_gust": 9.8,
                            "wind_dir": "nw",
                            "pressure_mm": 751,
                            "pressure_pa": 1001,
                            "humidity": 83,
                            "soil_temp": 8,
                            "soil_moisture": 0.24,
                            "prec_mm": 0.5,
                            "prec_prob": 90,
                            "prec_period": 360,
                            "cloudness": 1,
                            "prec_type": 1,
                            "prec_strength": 0.5,
                            "icon": "ovc_ra",
                            "condition": "rain",
                            "uv_index": 2,
                            "feels_like": 4,
                            "daytime": "d",
                            "polar": false
                        },
                        "day": {
                            "_source": "12,13,14,15,16,17",
                            "temp_min": 10,
                            "temp_avg": 11,
                            "temp_max": 11,
                            "wind_speed": 4.5,
                            "wind_gust": 10.1,
                            "wind_dir": "nw",
                            "pressure_mm": 751,
                            "pressure_pa": 1001,
                            "humidity": 66,
                            "soil_temp": 11,
                            "soil_moisture": 0.22,
                            "prec_mm": 0.1,
                            "prec_prob": 90,
                            "prec_period": 360,
                            "cloudness": 1,
                            "prec_type": 1,
                            "prec_strength": 0.25,
                            "icon": "ovc_-ra",
                            "condition": "light-rain",
                            "uv_index": 3,
                            "feels_like": 7,
                            "daytime": "d",
                            "polar": false
                        },
                        "night": {
                            "_source": "0,1,2,3,4,5",
                            "temp_min": 7,
                            "temp_avg": 8,
                            "temp_max": 8,
                            "wind_speed": 2.8,
                            "wind_gust": 6.6,
                            "wind_dir": "nw",
                            "pressure_mm": 752,
                            "pressure_pa": 1002,
                            "humidity": 92,
                            "soil_temp": 8,
                            "soil_moisture": 0.24,
                            "prec_mm": 0,
                            "prec_prob": 0,
                            "prec_period": 360,
                            "cloudness": 1,
                            "prec_type": 0,
                            "prec_strength": 0,
                            "icon": "ovc",
                            "condition": "overcast",
                            "uv_index": 0,
                            "feels_like": 5,
                            "daytime": "n",
                            "polar": false
                        },
                        "evening": {
                            "_source": "18,19,20,21",
                            "temp_min": 10,
                            "temp_avg": 11,
                            "temp_max": 11,
                            "wind_speed": 2.9,
                            "wind_gust": 8.5,
                            "wind_dir": "nw",
                            "pressure_mm": 749,
                            "pressure_pa": 998,
                            "humidity": 69,
                            "soil_temp": 11,
                            "soil_moisture": 0.22,
                            "prec_mm": 0,
                            "prec_prob": 0,
                            "prec_period": 240,
                            "cloudness": 1,
                            "prec_type": 0,
                            "prec_strength": 0,
                            "icon": "ovc",
                            "condition": "overcast",
                            "uv_index": 0,
                            "feels_like": 8,
                            "daytime": "n",
                            "polar": false
                        },
                        "night_short": {
                            "_source": "0,1,2,3,4,5",
                            "temp": 7,
                            "wind_speed": 2.8,
                            "wind_gust": 6.6,
                            "wind_dir": "nw",
                            "pressure_mm": 752,
                            "pressure_pa": 1002,
                            "humidity": 92,
                            "soil_temp": 8,
                            "soil_moisture": 0.24,
                            "prec_mm": 0,
                            "prec_prob": 0,
                            "prec_period": 360,
                            "cloudness": 1,
                            "prec_type": 0,
                            "prec_strength": 0,
                            "icon": "ovc",
                            "condition": "overcast",
                            "uv_index": 0,
                            "feels_like": 5,
                            "daytime": "n",
                            "polar": false
                        },
                        "day_short": {
                            "_source": "6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21",
                            "temp": 11,
                            "temp_min": 7,
                            "wind_speed": 4.6,
                            "wind_gust": 10.1,
                            "wind_dir": "nw",
                            "pressure_mm": 751,
                            "pressure_pa": 1001,
                            "humidity": 73,
                            "soil_temp": 10,
                            "soil_moisture": 0.22,
                            "prec_mm": 0.6,
                            "prec_prob": 90,
                            "prec_period": 960,
                            "cloudness": 1,
                            "prec_type": 1,
                            "prec_strength": 0.5,
                            "icon": "ovc_ra",
                            "condition": "rain",
                            "uv_index": 2,
                            "feels_like": 6,
                            "daytime": "d",
                            "polar": false
                        }
                    },
                    "hours": [],
                    "biomet": {
                        "index": 1,
                        "condition": "magnetic-field_1"
                    }
                },
                {
                    "date": "2022-09-07",
                    "date_ts": 1662498000,
                    "week": 36,
                    "sunrise": "05:45",
                    "sunset": "19:10",
                    "rise_begin": "05:06",
                    "set_end": "19:48",
                    "moon_code": 14,
                    "moon_text": "moon-code-14",
                    "parts": {
                        "night_short": {
                            "_source": "22,23,0,1,2,3,4,5",
                            "temp": 8,
                            "wind_speed": 3,
                            "wind_gust": 7.4,
                            "wind_dir": "w",
                            "pressure_mm": 748,
                            "pressure_pa": 997,
                            "humidity": 76,
                            "soil_temp": 10,
                            "soil_moisture": 0.22,
                            "prec_mm": 0,
                            "prec_prob": 0,
                            "prec_period": 480,
                            "cloudness": 1,
                            "prec_type": 0,
                            "prec_strength": 0,
                            "icon": "ovc",
                            "condition": "overcast",
                            "uv_index": 0,
                            "feels_like": 6,
                            "daytime": "n",
                            "polar": false
                        },
                        "night": {
                            "_source": "22,23,0,1,2,3,4,5",
                            "temp_min": 8,
                            "temp_avg": 9,
                            "temp_max": 9,
                            "wind_speed": 3,
                            "wind_gust": 7.4,
                            "wind_dir": "w",
                            "pressure_mm": 748,
                            "pressure_pa": 997,
                            "humidity": 76,
                            "soil_temp": 10,
                            "soil_moisture": 0.22,
                            "prec_mm": 0,
                            "prec_prob": 0,
                            "prec_period": 480,
                            "cloudness": 1,
                            "prec_type": 0,
                            "prec_strength": 0,
                            "icon": "ovc",
                            "condition": "overcast",
                            "uv_index": 0,
                            "feels_like": 6,
                            "daytime": "n",
                            "polar": false
                        },
                        "day": {
                            "_source": "12,13,14,15,16,17",
                            "temp_min": 10,
                            "temp_avg": 11,
                            "temp_max": 12,
                            "wind_speed": 4.7,
                            "wind_gust": 10.7,
                            "wind_dir": "w",
                            "pressure_mm": 746,
                            "pressure_pa": 994,
                            "humidity": 70,
                            "soil_temp": 13,
                            "soil_moisture": 0.23,
                            "prec_mm": 41.6,
                            "prec_prob": 60,
                            "prec_period": 360,
                            "cloudness": 1,
                            "prec_type": 1,
                            "prec_strength": 1,
                            "icon": "ovc_+ra",
                            "condition": "showers",
                            "uv_index": 2,
                            "feels_like": 7,
                            "daytime": "d",
                            "polar": false
                        },
                        "morning": {
                            "_source": "6,7,8,9,10,11",
                            "temp_min": 8,
                            "temp_avg": 9,
                            "temp_max": 11,
                            "wind_speed": 3.8,
                            "wind_gust": 7.9,
                            "wind_dir": "w",
                            "pressure_mm": 747,
                            "pressure_pa": 995,
                            "humidity": 75,
                            "soil_temp": 9,
                            "soil_moisture": 0.22,
                            "prec_mm": 0.3,
                            "prec_prob": 20,
                            "prec_period": 360,
                            "cloudness": 1,
                            "prec_type": 1,
                            "prec_strength": 0.25,
                            "icon": "ovc_-ra",
                            "condition": "light-rain",
                            "uv_index": 2,
                            "feels_like": 5,
                            "daytime": "d",
                            "polar": false
                        },
                        "evening": {
                            "_source": "18,19,20,21",
                            "temp_min": 10,
                            "temp_avg": 10,
                            "temp_max": 10,
                            "wind_speed": 2.8,
                            "wind_gust": 6.8,
                            "wind_dir": "w",
                            "pressure_mm": 746,
                            "pressure_pa": 994,
                            "humidity": 89,
                            "soil_temp": 11,
                            "soil_moisture": 0.27,
                            "prec_mm": 60.1,
                            "prec_prob": 50,
                            "prec_period": 240,
                            "cloudness": 1,
                            "prec_type": 1,
                            "prec_strength": 1,
                            "icon": "ovc_+ra",
                            "condition": "showers",
                            "uv_index": 0,
                            "feels_like": 8,
                            "daytime": "n",
                            "polar": false
                        },
                        "day_short": {
                            "_source": "6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21",
                            "temp": 12,
                            "temp_min": 8,
                            "wind_speed": 4.7,
                            "wind_gust": 10.7,
                            "wind_dir": "w",
                            "pressure_mm": 746,
                            "pressure_pa": 994,
                            "humidity": 76,
                            "soil_temp": 11,
                            "soil_moisture": 0.22,
                            "prec_mm": 102,
                            "prec_prob": 60,
                            "prec_period": 960,
                            "cloudness": 1,
                            "prec_type": 1,
                            "prec_strength": 1,
                            "icon": "ovc_+ra",
                            "condition": "showers",
                            "uv_index": 2,
                            "feels_like": 6,
                            "daytime": "d",
                            "polar": false
                        }
                    },
                    "hours": [],
                    "biomet": {
                        "index": 0,
                        "condition": "magnetic-field_0"
                    }
                }
            ]
        }
    """.trimIndent()
        val k = Gson().fromJson(b, WeatherApiResponse::class.java)
        println(k)
    }
}