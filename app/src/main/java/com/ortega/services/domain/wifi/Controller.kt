package com.ortega.services.domain.wifi

import kotlinx.coroutines.flow.StateFlow

interface Controller {

    val scannedDevices: StateFlow<List<WifiModel>>

    fun startScan()
    fun stopScan()

}