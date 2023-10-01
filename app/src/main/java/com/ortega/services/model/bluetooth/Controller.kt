package com.ortega.services.model.bluetooth

import kotlinx.coroutines.flow.StateFlow

interface Controller {

    val scannedDevices: StateFlow<List<BluetoothModel>>
    val pairedDevices: StateFlow<List<BluetoothModel>>

    fun startScan()
    fun stopScan()

    fun release()


}