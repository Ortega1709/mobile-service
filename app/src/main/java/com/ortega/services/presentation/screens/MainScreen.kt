package com.ortega.services.presentation.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Bluetooth
import androidx.compose.material.icons.rounded.Wifi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import com.ortega.services.R
import com.ortega.services.presentation.components.ServiceItemComponent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {

    // nested scroll
    val scrollBehavior = TopAppBarDefaults
        .exitUntilCollapsedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        topBar = {
            MediumTopAppBar(
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    scrolledContainerColor = MaterialTheme.colorScheme.background
                ),
                title = { Text(text = stringResource(R.string.services)) },
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
                    icon = Icons.Rounded.Bluetooth,
                    title = stringResource(R.string.bluetooth),
                    description = stringResource(R.string.bluetooth_desc)
                ) {

                }
                ServiceItemComponent(
                    icon = Icons.Rounded.Wifi,
                    title = stringResource(R.string.wi_fi),
                    description = stringResource(R.string.wifi_desc)
                ) {

                }
            }

        }
    }

}