package com.ortega.services.presentation

import android.Manifest
import android.app.NotificationManager
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.hilt.navigation.compose.hiltViewModel
import com.ortega.services.presentation.screens.notification.NotificationScreen
import com.ortega.services.presentation.screens.notification.NotificationViewModel
import com.ortega.services.presentation.theme.ServicesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationActivity : ComponentActivity() {

    private val postNotificationLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){  }

    private val permissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) {
        perms ->

        val canPostNotification = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            perms[Manifest.permission.POST_NOTIFICATIONS] == true
        } else true

        if (canPostNotification) {
            postNotificationLauncher.launch(
                Intent(NotificationManager.ACTION_NOTIFICATION_POLICY_ACCESS_GRANTED_CHANGED)
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ServicesTheme {

                val viewModel: NotificationViewModel = hiltViewModel()
                NotificationScreen(viewModel = viewModel)
            }
        }
    }
}

