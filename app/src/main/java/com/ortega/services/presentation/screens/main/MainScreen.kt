package com.ortega.services.presentation.screens.main

import android.content.Intent
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Bluetooth
import androidx.compose.material.icons.rounded.FlashlightOn
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Vibration
import androidx.compose.material.icons.rounded.Wifi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.ortega.services.R
import com.ortega.services.presentation.BluetoothActivity
import com.ortega.services.presentation.LightActivity
import com.ortega.services.presentation.NotificationActivity
import com.ortega.services.presentation.VibratorActivity
import com.ortega.services.presentation.WifiActivity
import com.ortega.services.presentation.components.ServiceItemComponent
import com.ortega.services.presentation.components.TopAppBarComponent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {


    val scrollBehavior =
        TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())

    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBarComponent(
                title = stringResource(R.string.services),
                scrollBehavior = scrollBehavior
            )
        },
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
    ) {
        LazyColumn(
            modifier = Modifier.padding(paddingValues = it)
        ) {

            item {

                ServiceItemComponent(
                    enabled = true,
                    icon = Icons.Rounded.Bluetooth,
                    title = stringResource(R.string.bluetooth),
                    description = stringResource(R.string.bluetooth_desc)
                ) {

                    val intent = Intent(context, BluetoothActivity::class.java).setAction("")
                    context.startActivity(intent)

                }

                ServiceItemComponent(
                    enabled = true,
                    icon = Icons.Rounded.Wifi,
                    title = stringResource(R.string.wi_fi),
                    description = stringResource(R.string.wifi_desc)
                ) {

                    val intent = Intent(context, WifiActivity::class.java).setAction("")
                    context.startActivity(intent)

                }

                ServiceItemComponent(
                    icon = Icons.Rounded.Vibration,
                    title = stringResource(R.string.vibrate),
                    description = stringResource(R.string.vibrate_desc),
                    enabled = true) {

                    val intent = Intent(context, VibratorActivity::class.java).setAction("")
                    context.startActivity(intent)

                }

                ServiceItemComponent(
                    icon = Icons.Rounded.FlashlightOn,
                    title = stringResource(R.string.torch),
                    description = stringResource(R.string.flash_desc),
                    enabled = true) {

                    val intent = Intent(context, LightActivity::class.java).setAction("")
                    context.startActivity(intent)

                }

                ServiceItemComponent(
                    icon = Icons.Rounded.Notifications,
                    title = stringResource(R.string.notifications),
                    description = stringResource(R.string.notifications_desc),
                    enabled = true) {

                    val intent = Intent(context, NotificationActivity::class.java).setAction("")
                    context.startActivity(intent)

                }
            }

        }
    }

}