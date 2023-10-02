package com.ortega.services.services.light

import android.content.Context
import android.content.pm.PackageManager
import android.hardware.camera2.CameraManager
import com.ortega.services.domain.light.Controller
import javax.inject.Inject

class LightController @Inject constructor(private val context: Context): Controller {

    private val cameraManager by lazy { context.getSystemService(CameraManager::class.java) }

    override fun startLight() {

        // get back camera
        val cameraId = cameraManager.cameraIdList[0]
        cameraManager.setTorchMode(cameraId, true)

    }

    override fun stopLight() {
       val cameraId = cameraManager.cameraIdList[0]
        cameraManager.setTorchMode(cameraId, false)
    }

    override fun isLightAvailable(): Boolean {
        return context.packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)
    }
}