package com.ortega.services.presentation.screens.wifi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ortega.services.data.wifi.WifiController
import com.ortega.services.presentation.screens.bluetooth.BluetoothUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class WifiViewModel @Inject constructor(private val wifiController: WifiController): ViewModel() {

    private val _state = MutableStateFlow(WifiUiState())
    val state = combine(
        wifiController.scannedDevices,
        _state
    )
    {
            scannedDevices, state ->
        state.copy(scannedDevices = scannedDevices)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), _state.value)


    fun startScan() {
        wifiController.startScan()
    }

    fun stopScan() {
        wifiController.stopScan()
    }

}