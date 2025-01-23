package com.plcoding.composemedicallapp.util
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember


sealed class Screen {
    object Main : Screen()
    object Graph : Screen()
}