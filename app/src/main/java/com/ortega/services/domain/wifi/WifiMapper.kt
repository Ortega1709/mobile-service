package com.ortega.services.domain.wifi

import android.net.wifi.ScanResult

fun ScanResult.toWifiModel(): WifiModel {
    return WifiModel(
        bssid = BSSID,
        frequency = frequency
    )
}