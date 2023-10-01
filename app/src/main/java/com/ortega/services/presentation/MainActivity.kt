package com.ortega.services.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ortega.services.presentation.screens.main.MainScreen
import com.ortega.services.presentation.screens.main.MainViewModel
import com.ortega.services.presentation.theme.ServicesTheme
import dagger.hilt.android.AndroidEntryPoint

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ServicesTheme {
                MainScreen(viewModel = MainViewModel(this))
            }
        }
    }
}
