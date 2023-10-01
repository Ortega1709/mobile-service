package com.ortega.services.model.bluetooth

import android.annotation.SuppressLint
import android.bluetooth.BluetoothDevice


@SuppressLint("MissingPermission")
fun BluetoothDevice.toBluetoothModel(): BluetoothModel {
    return BluetoothModel(
        name = name,
        address = address
    )
}