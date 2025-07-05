package com.nhz.designpatterns.patterns.creationalPatterns.factoryMethod.notificationSystem.notification

class EmailNotification: Notification {
    override fun sendNotification() {
        println("Email notification sent to the user!")
    }
}