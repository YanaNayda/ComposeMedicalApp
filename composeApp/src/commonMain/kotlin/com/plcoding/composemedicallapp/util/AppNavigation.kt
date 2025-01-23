package com.plcoding.composemedicallapp.util
import GraphScreen
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember


@Composable
fun AppNavigation(currentScreen: MutableState<Screen>) {
    when (currentScreen.value) {
        is Screen.Main -> MainScreen(onNavigateToGraph = { currentScreen.value = Screen.Graph })
        is Screen.Graph -> GraphScreen()

    }
}


