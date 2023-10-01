package com.ortega.services.presentation.components.bluetooth

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.ortega.services.R
import com.ortega.services.model.bluetooth.BluetoothModel

@Composable
fun BluetoothDeviceList(
    scannedDevices: List<BluetoothModel>,
    pairedDevices: List<BluetoothModel>
) {

    LazyColumn {
        
        item { 
            ListItem(headlineContent = { Text(text = stringResource(R.string.paired_devices)) })
        }

        items(pairedDevices) { device ->
            BluetoothDeviceComponent(name = device.name, address = device.address)
        }
        
        item { 
            ListItem(headlineContent = { Text(text = stringResource(R.string.devices_found)) })
        }

        items(scannedDevices) { device ->
            BluetoothDeviceComponent(name = device.name, address = device.address)
        }
    }

} 