package com.example.weatherappcompose.ui.screens.settings

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.jamal.composeprefs3.ui.PrefsScreen
import com.jamal.composeprefs3.ui.prefs.CheckBoxPref
import com.jamal.composeprefs3.ui.prefs.EditTextPref
import ru.mosit.weatherapp.dataStore

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SettingsScreen(padding: PaddingValues) {
    Surface(modifier = Modifier.padding(padding)) {
        PrefsScreen(
            dataStore = LocalContext.current.dataStore,
        ) {
            prefsItem {
                EditTextPref(
                    key = "location",
                    title = "Текущая позиция",
                    summary = "Определяет местоположение, для которого ",
                    dialogTitle = "Изменение текущего местоположения",
                    dialogMessage = "Укажите координаты места, для которого хотите получать погоду (например: 55.757,37.615)",
                    enabled = false
                )
                CheckBoxPref(
                    key = "location_auto",
                    title = "Получать местоположение по GPS",
                    summary = "Автоматическое определение местоположение. Требует разрешения к данным о местоположении ",
                )
            }
        }
    }
}
