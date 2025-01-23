package com.plcoding.composemedicallapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.plcoding.composemedicallapp.util.AppNavigation
import com.plcoding.composemedicallapp.util.MainScreen
import com.plcoding.composemedicallapp.util.Screen

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import android.content.Context

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.plcoding.composemedicallapp.R


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            YourComposableContent()
        }
        // Состояние для отслеживания текущего экрана





    }
}
@Composable
fun YourComposableContent() {
    val screen = remember { mutableStateOf<Screen>(Screen.Main) }

    AppNavigation(currentScreen = screen)
}

@Preview
@Composable
fun AppAndroidPreview() {
    YourComposableContent()
}


