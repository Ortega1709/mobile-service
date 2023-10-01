package com.ortega.services.domain.bluetooth

import kotlinx.coroutines.flow.StateFlow

interface Controller {

    val scannedDevices: StateFlow<List<BluetoothModel>>
    val pairedDevices: StateFlow<List<BluetoothModel>>

    fun startScan()
    fun stopScan()

    fun release()


}