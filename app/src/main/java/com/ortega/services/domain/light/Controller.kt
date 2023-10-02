package com.ortega.services.domain.light

interface Controller {

    fun startLight()
    fun stopLight()

    fun isLightAvailable(): Boolean

}