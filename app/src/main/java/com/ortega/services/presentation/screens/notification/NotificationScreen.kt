package com.ortega.services.presentation.screens.notification

import android.app.Activity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Send
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ortega.services.R
import com.ortega.services.presentation.components.ActivateServiceComponent
import com.ortega.services.presentation.components.HeightSpacer
import com.ortega.services.presentation.components.TopAppBarComponent
import com.ortega.services.presentation.components.WidthSpacer
import com.ortega.services.presentation.components.wifi.WifiDeviceList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationScreen(viewModel: NotificationViewModel) {

    val scrollBehavior = TopAppBarDefaults
        .exitUntilCollapsedScrollBehavior(rememberTopAppBarState())

    val context = LocalContext.current
    var notificationField by rememberSaveable {
        mutableStateOf("")
    }

    Scaffold(
        topBar = {
            TopAppBarComponent(
                title = stringResource(id = R.string.notifications),
                actions = {},
                onClickNavigation = { (context as? Activity)?.finish() },
                scrollBehavior = scrollBehavior
            )
        },
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
    ) {
        paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues = paddingValues)
        ) {

            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
            ) {

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = notificationField,
                    label = { Text(text = stringResource(R.string.message)) },
                    onValueChange = { notificationField = it }
                )

                HeightSpacer(height = 16.dp)

                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        if (notificationField != "") {
                            viewModel.push(
                                title = "Notification",
                                message = notificationField
                            )
                        }
                    }
                ) {
                    Text(text = stringResource(R.string.send_notification))
                }
            }

        }
    }
}