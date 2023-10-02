package com.ortega.services.module

import android.content.Context
import com.ortega.services.services.bluetooth.BluetoothController
import com.ortega.services.services.light.LightController
import com.ortega.services.services.vibrator.VibratorController
import com.ortega.services.services.wifi.WifiController
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideBluetoothController(@ApplicationContext context: Context): BluetoothController {
        return BluetoothController(context)
    }

    @Provides
    @Singleton
    fun provideWifiController(@ApplicationContext context: Context): WifiController {
        return WifiController(context)
    }

    @Provides
    @Singleton
    fun provideVibratorController(@ApplicationContext context: Context): VibratorController {
        return VibratorController(context)
    }

    @Provides
    @Singleton
    fun provideLightController(@ApplicationContext context: Context): LightController {
        return LightController(context)
    }

}