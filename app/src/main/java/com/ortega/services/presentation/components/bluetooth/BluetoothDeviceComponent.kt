package com.ortega.services.presentation.components.bluetooth

import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.ortega.services.R

@Composable
fun BluetoothDeviceComponent(
    name: String?,
    address: String
) {
    ListItem(
        headlineContent = { Text(text = name ?: stringResource(R.string.no_name)) },
        supportingContent = { Text(text = address) }
    )
}