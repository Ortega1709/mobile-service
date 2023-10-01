package com.ortega.services.services.wifi

import android.Manifest
import android.content.Context
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.net.wifi.WifiManager
import com.ortega.services.domain.wifi.Controller
import com.ortega.services.domain.wifi.WifiModel
import com.ortega.services.domain.wifi.toWifiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class WifiController @Inject constructor(private val context: Context) : Controller {

    private val wifiManager by lazy { context.getSystemService(WifiManager::class.java) }

    private val _scannedDevices = MutableStateFlow<List<WifiModel>>(emptyList())
    override val scannedDevices: StateFlow<List<WifiModel>>
        get() = _scannedDevices.asStateFlow()

    private val foundDeviceReceiver = FoundDeviceReceiver { scanResult ->
        _scannedDevices.update { devices ->
            println("devices $scanResult")
            val newDevice = scanResult.toWifiModel()
            if (newDevice in devices) devices else devices + newDevice
        }
    }

    override fun startScan() {
        if (!hasPermission(Manifest.permission.ACCESS_WIFI_STATE)) {
            return
        }

        context.registerReceiver(
            foundDeviceReceiver,
            IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION)
        )

        wifiManager.startScan()

    }

    override fun stopScan() {
        context.unregisterReceiver(foundDeviceReceiver)
    }

    private fun hasPermission(permission: String): Boolean {
        return context.checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED
    }
}