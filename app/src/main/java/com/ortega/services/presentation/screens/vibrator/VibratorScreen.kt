package com.ortega.services.presentation.screens.vibrator

import android.app.Activity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ortega.services.R
import com.ortega.services.presentation.components.ActivateServiceComponent
import com.ortega.services.presentation.components.TopAppBarComponent
import com.ortega.services.presentation.components.WidthSpacer
import com.ortega.services.presentation.components.wifi.WifiDeviceList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VibratorScreen(
    onStartVibrator: () -> Unit,
    onStopVibrator: () -> Unit
) {

    val scrollBehavior = TopAppBarDefaults
        .exitUntilCollapsedScrollBehavior(rememberTopAppBarState())

    val context = LocalContext.current
    var activate by rememberSaveable { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBarComponent(
                title = stringResource(id = R.string.vibrate),
                actions = {
                },
                onClickNavigation = { (context as? Activity)?.finish() },
                scrollBehavior = scrollBehavior
            )
        },
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
    ) {
        Column(
            modifier = Modifier.padding(paddingValues = it)
        ) {

            ActivateServiceComponent(title = stringResource(id = R.string.activate)) {
                Switch(
                    checked = activate,
                    onCheckedChange = {
                        activate = !activate
                        if (activate) onStartVibrator() else onStopVibrator()
                    }
                )
            }

        }
    }

}