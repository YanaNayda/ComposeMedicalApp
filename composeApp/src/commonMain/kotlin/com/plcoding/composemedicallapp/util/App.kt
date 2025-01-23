package com.plcoding.composemedicallapp.util
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import org.jetbrains.compose.ui.tooling.preview.Preview

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember


@Composable
fun MedApp() {

    val currentScreen = remember { mutableStateOf<Screen>(Screen.Main) }


    AppNavigation(currentScreen = currentScreen)
}

@Preview()
@Composable
fun DefaultPreview() {
    MedApp()
}