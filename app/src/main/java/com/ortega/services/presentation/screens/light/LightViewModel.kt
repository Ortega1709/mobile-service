package com.ortega.services.presentation.screens.light

import androidx.lifecycle.ViewModel
import com.ortega.services.services.light.LightController
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LightViewModel @Inject constructor(private val lightController: LightController): ViewModel() {

    fun startLight() {
        lightController.startLight()
    }

    fun stopLight() {
        lightController.stopLight()
    }

    fun isLightAvailable(): Boolean {
        return lightController.isLightAvailable()
    }
}