package com.ortega.services.presentation.screens.notification

import androidx.lifecycle.ViewModel
import com.ortega.services.services.notification.NotificationController
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NotificationViewModel @Inject constructor(private val notificationController: NotificationController): ViewModel() {

    fun push(title: String, message: String) {
        notificationController.push(title, message)
    }

}
