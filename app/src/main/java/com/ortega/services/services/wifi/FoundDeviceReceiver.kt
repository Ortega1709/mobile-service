package com.ortega.services.services.wifi

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.wifi.ScanResult
import android.net.wifi.WifiManager

@SuppressLint("MissingPermission")
class FoundDeviceReceiver (
    private val onDeviceFound: (ScanResult) -> Unit
): BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        val wifiManager by lazy { context?.getSystemService(WifiManager::class.java) }

        val success = intent?.getBooleanExtra(WifiManager.EXTRA_RESULTS_UPDATED, false)
        if (success == true) {

            val results = wifiManager?.scanResults
            results?.map { it.let(onDeviceFound) }

        }

    }


}