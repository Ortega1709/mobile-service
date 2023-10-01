package com.ortega.services.services.vibrator

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.os.CombinedVibration
import android.os.VibrationEffect
import android.os.VibratorManager
import com.ortega.services.domain.vibrator.Controller
import javax.inject.Inject

@SuppressLint("NewApi")
class VibratorController @Inject constructor(private val context: Context) : Controller {

    private val vibrator by lazy { context.getSystemService(VibratorManager::class.java) }

    override fun startVibrator() {
        vibrator.vibrate(
            CombinedVibration.createParallel(
                VibrationEffect.createOneShot(
                    1000,
                    VibrationEffect.EFFECT_HEAVY_CLICK
                )
            )
        )
    }

    override fun stopVibrator() {
        vibrator.cancel()
    }

    private fun hasPermission(permission: String): Boolean {
        return context.checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED
    }
}