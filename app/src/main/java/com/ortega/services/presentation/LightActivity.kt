package com.ortega.services.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import com.ortega.services.presentation.screens.light.LightScreen
import com.ortega.services.presentation.screens.light.LightViewModel
import com.ortega.services.presentation.screens.wifi.WifiViewModel
import com.ortega.services.presentation.theme.ServicesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LightActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ServicesTheme {

                val viewModel: LightViewModel = hiltViewModel()
                LightScreen(
                    startLight = viewModel::startLight,
                    stopLight = viewModel::stopLight
                )
            }
        }
    }
}