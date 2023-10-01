package com.ortega.services.presentation.components.wifi

import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun WifiDeviceComponent(
    bssid: String,
    frequency: Int
) {


    ListItem(
        headlineContent = { Text(text = bssid) },
        supportingContent = { Text(text = frequency.toString()) }
    )

}