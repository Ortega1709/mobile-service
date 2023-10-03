package com.ortega.services.domain.notification

interface Controller {

    fun push(title: String, message: String)

}