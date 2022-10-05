package com.example.weatherappcompose.ui.screens.home.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(title: String) {
    SmallTopAppBar(
        title = { Text(title) },

        )


}

@Preview
@Composable
fun HomeTopBarPreview() {
    HomeTopBar("Город")
}
