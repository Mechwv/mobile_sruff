package com.example.weatherappcompose

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.weatherappcompose.ui.navigation.NavGraph
import com.example.weatherappcompose.ui.navigation.Screen
import com.example.weatherappcompose.ui.screens.home.view.HomeTopBar
import com.example.weatherappcompose.ui.theme.WeatherAppComposeTheme
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.hilt.android.AndroidEntryPoint

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@ExperimentalAnimationApi
@AndroidEntryPoint
class MainActivity1 : ComponentActivity() {



    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {
            WeatherAppComposeTheme {
                val navController = rememberNavController()
                val backStackEntry by navController.currentBackStackEntryAsState()
                val (fabOnClick, setFabOnClick) = remember { mutableStateOf<(() -> Unit)?>(null) }

                val currentRoute = backStackEntry?.destination?.route
                Scaffold(
                    topBar = {
                        HomeTopBar(
                            when (currentRoute) {
                                Screen.Home.route -> "Погода"
                                Screen.Settings.route -> "Настройки"
                                else -> ""
                            }
                        )
                    },
                    floatingActionButton = {
                        ExtendedFloatingActionButton(
                            icon = {
                                Icon(
                                    Icons.Filled.Refresh,
                                    contentDescription = null
                                )
                            },
                            text = { Text("Обновить") }, onClick = { fabOnClick?.invoke() }
                        )
                    },
                    bottomBar = {
                        NavigationBar {
                            NavigationBarItem(
                                icon = { Icon(Screen.Home.icon, contentDescription = null) },
                                label = { Text(Screen.Home.title) },
                                selected = Screen.Home.route == currentRoute,
                                onClick = {
                                    navController.navigate(Screen.Home.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }

                                }
                            )
                            NavigationBarItem(
                                icon = { Icon(Screen.Settings.icon, contentDescription = null) },
                                label = { Text(Screen.Settings.title) },
                                selected = Screen.Settings.route == currentRoute,
                                onClick = {
                                    navController.navigate(Screen.Settings.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }

                                }
                            )
                        }
                    },

                    content = {
                        NavGraph(navController = navController, it, setFabOnClick)
                    })


            }
        }
    }

}