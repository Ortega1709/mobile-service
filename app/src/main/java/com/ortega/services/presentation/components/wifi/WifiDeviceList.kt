package com.ortega.services.presentation.components.wifi

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.ortega.services.R
import com.ortega.services.domain.wifi.WifiModel

@Composable
fun WifiDeviceList(scannedDevices: List<WifiModel>) {

    LazyColumn {

        item {
            ListItem(headlineContent = { Text(text = stringResource(R.string.devices_found)) })
        }

        items(scannedDevices) { device ->
            WifiDeviceComponent(bssid = device.bssid, frequency = device.frequency)
        }
    }

}