package com.ortega.services.presentation.screens.wifi

import com.ortega.services.domain.wifi.WifiModel

data class WifiUiState(
    val scannedDevices: List<WifiModel> = emptyList()
)

