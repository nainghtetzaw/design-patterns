package com.nhz.designpatterns.patterns.creationalPatterns.factoryMethod.notificationSystem.notification

class PushNotification: Notification {
    override fun sendNotification() {
        println("Push notification sent to the user!")
    }
}