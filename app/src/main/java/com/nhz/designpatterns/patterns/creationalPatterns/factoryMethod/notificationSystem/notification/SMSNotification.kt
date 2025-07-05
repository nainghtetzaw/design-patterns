package com.nhz.designpatterns.patterns.creationalPatterns.factoryMethod.notificationSystem.notification

class SMSNotification: Notification {
    override fun sendNotification() {
        println("SMS notification sent to the user!")
    }
}