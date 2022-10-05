package com.example.weatherappcompose.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.mosit.weatherapp.presentation.screens.home.HomeScreen
import com.example.weatherappcompose.ui.screens.settings.SettingsScreen


@Composable
fun NavGraph(
    navController: NavHostController,
    paddings: PaddingValues,
    setFabOnClick: (() -> Unit) -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController, paddings, setFabOnClick)
        }
        composable(route = Screen.Settings.route) {
            SettingsScreen( paddings)
        }
    }
}