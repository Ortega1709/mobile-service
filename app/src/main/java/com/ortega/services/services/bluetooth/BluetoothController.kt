package com.ortega.services.services.bluetooth

import android.Manifest
import android.annotation.SuppressLint
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothManager
import android.content.Context
import android.content.IntentFilter
import android.content.pm.PackageManager
import com.ortega.services.domain.bluetooth.BluetoothModel
import com.ortega.services.domain.bluetooth.Controller
import com.ortega.services.domain.bluetooth.toBluetoothModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@SuppressLint("MissingPermission")
class BluetoothController @Inject constructor(private val context: Context) : Controller {

    private val bluetoothManager by lazy { context.getSystemService(BluetoothManager::class.java) }
    private val bluetoothAdapter by lazy { bluetoothManager?.adapter }


    private val _scannedDevices = MutableStateFlow<List<BluetoothModel>>(emptyList())
    override val scannedDevices: StateFlow<List<BluetoothModel>>
        get() = _scannedDevices.asStateFlow()

    private val _pairedDevices = MutableStateFlow<List<BluetoothModel>>(emptyList())
    override val pairedDevices: StateFlow<List<BluetoothModel>>
        get() = _pairedDevices.asStateFlow()

    init {
        updatedPairedDevices()
    }

    private val foundDeviceReceiver = FoundDeviceReceiver {device ->
        _scannedDevices.update {devices ->
            val newDevice = device.toBluetoothModel()
            if (newDevice in devices) devices else devices + newDevice
        }
    }

    override fun startScan() {
        if (!hasPermission(Manifest.permission.BLUETOOTH_SCAN)) {
            return
        }

        context.registerReceiver(foundDeviceReceiver, IntentFilter(BluetoothDevice.ACTION_FOUND))
        updatedPairedDevices()
        bluetoothAdapter?.startDiscovery()

    }

    override fun stopScan() {
        if (!hasPermission(Manifest.permission.BLUETOOTH_SCAN)) {
            return
        }

        println("Start scan")
        bluetoothAdapter?.cancelDiscovery()
    }

    override fun release() {
        context.unregisterReceiver(foundDeviceReceiver)
    }

    private fun updatedPairedDevices() {
        if (!hasPermission(Manifest.permission.BLUETOOTH_CONNECT)) {
            return
        }

        bluetoothAdapter
            ?.bondedDevices
            ?.map { it.toBluetoothModel() }
            ?.also {devices ->
                _pairedDevices.update { devices }
            }
    }

    private fun hasPermission(permission: String): Boolean {
        return context.checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED
    }

}