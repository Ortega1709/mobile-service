package com.ortega.services.presentation

import android.Manifest
import android.content.Intent
import android.net.wifi.WifiManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.ortega.services.presentation.screens.wifi.WifiScreen
import com.ortega.services.presentation.screens.wifi.WifiViewModel
import com.ortega.services.presentation.theme.ServicesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WifiActivity : ComponentActivity() {

    private val wifiManager by lazy {
        applicationContext.getSystemService(WifiManager::class.java)
    }

    private val isWifiEnabled: Boolean
        get() = wifiManager.isWifiEnabled

    private val enableWifiLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {  }

    private val permissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) {
        perms ->
        val canEnableWifi = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            perms[Manifest.permission.ACCESS_WIFI_STATE] == true
        } else true

        if (canEnableWifi && !isWifiEnabled) {
            enableWifiLauncher.launch(
                Intent(WifiManager.ACTION_PICK_WIFI_NETWORK)
            )
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ServicesTheme {
                LaunchedEffect(true) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                        permissionLauncher.launch(
                            arrayOf(
                                Manifest.permission.ACCESS_WIFI_STATE,
                                Manifest.permission.CHANGE_WIFI_STATE
                            )
                        )
                    }
                }

                val viewModel: WifiViewModel = hiltViewModel()
                val state by viewModel.state.collectAsState()

                WifiScreen(
                    state = state,
                    onStartScan = viewModel::startScan,
                    onStopScan = viewModel::stopScan
                )

            }
        }
    }
}
