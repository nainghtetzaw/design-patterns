package com.nhz.designpatterns.patterns.creationalPatterns.factoryMethod.notificationSystem

import com.nhz.designpatterns.patterns.creationalPatterns.factoryMethod.notificationSystem.factory.createNotification
import com.nhz.designpatterns.patterns.creationalPatterns.factoryMethod.notificationSystem.notification.Notification

fun main() {
    val notification: Notification = createNotification(NotificationType.SMS)
    notification.sendNotification()
}