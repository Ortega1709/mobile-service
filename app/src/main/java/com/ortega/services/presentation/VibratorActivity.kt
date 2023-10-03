package com.ortega.services.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import com.ortega.services.presentation.screens.vibrator.VibratorScreen
import com.ortega.services.presentation.screens.vibrator.VibratorViewModel
import com.ortega.services.presentation.theme.ServicesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VibratorActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ServicesTheme {

                val viewModel: VibratorViewModel = hiltViewModel()
                VibratorScreen(
                    onStartVibrator = viewModel::startVibrate,
                    onStopVibrator = viewModel::stopVibrate
                )
            }
        }
    }
}
