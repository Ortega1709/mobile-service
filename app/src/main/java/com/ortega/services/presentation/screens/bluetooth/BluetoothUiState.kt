package com.ortega.services.presentation.screens.bluetooth

import com.ortega.services.domain.bluetooth.BluetoothModel

data class BluetoothUiState(
    val scannedDevices: List<BluetoothModel> = emptyList(),
    val pairedDevices: List<BluetoothModel> = emptyList()
)
