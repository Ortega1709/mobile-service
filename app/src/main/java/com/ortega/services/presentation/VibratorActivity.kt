package com.ortega.services.presentation

import android.Manifest
import android.content.Intent
import android.net.wifi.WifiManager
import android.os.Build
import android.os.Bundle
import android.os.VibratorManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.ortega.services.presentation.screens.bluetooth.BluetoothViewModel
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
