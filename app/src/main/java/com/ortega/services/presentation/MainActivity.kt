package com.ortega.services.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ortega.services.presentation.screens.main.MainScreen
import com.ortega.services.presentation.theme.ServicesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ServicesTheme {
                MainScreen()
            }
        }
    }
}
