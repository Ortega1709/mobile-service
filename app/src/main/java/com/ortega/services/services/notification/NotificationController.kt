package com.ortega.services.services.notification

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Parcel
import androidx.core.app.NotificationCompat
import com.ortega.services.R
import com.ortega.services.domain.notification.Controller
import javax.inject.Inject
import kotlin.random.Random

@SuppressLint("NewApi")
class NotificationController @Inject constructor(private val context: Context) : Controller {

    private val notificationManager by lazy {
        context.getSystemService(NotificationManager::class.java)
    }

    private val channel = NotificationChannel(
        "channel-id", "channel-name", NotificationManager.IMPORTANCE_HIGH)

    override fun push(title: String, message: String) {

        val notification = NotificationCompat.Builder(context, channel.id)
            .setContentTitle(title)
            .setContentText(message)
            .setSmallIcon(R.drawable.launcher)
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .setAutoCancel(true)
            .build()

        notificationManager.notify(Random.nextInt(), notification)


    }
}