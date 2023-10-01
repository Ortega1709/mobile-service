package com.ortega.services.presentation.screens.vibrator

import androidx.lifecycle.ViewModel
import com.ortega.services.services.vibrator.VibratorController
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class VibratorViewModel @Inject constructor(private val vibratorController: VibratorController) :
    ViewModel() {

    fun startVibrate() {
        vibratorController.startVibrator()
    }

    fun stopVibrate() {

    }

}