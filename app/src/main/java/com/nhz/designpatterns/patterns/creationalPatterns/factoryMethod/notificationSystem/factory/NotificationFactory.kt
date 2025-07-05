package com.nhz.designpatterns.patterns.creationalPatterns.factoryMethod.notificationSystem.factory

import com.nhz.designpatterns.patterns.creationalPatterns.factoryMethod.notificationSystem.NotificationType
import com.nhz.designpatterns.patterns.creationalPatterns.factoryMethod.notificationSystem.notification.EmailNotification
import com.nhz.designpatterns.patterns.creationalPatterns.factoryMethod.notificationSystem.notification.Notification
import com.nhz.designpatterns.patterns.creationalPatterns.factoryMethod.notificationSystem.notification.PushNotification
import com.nhz.designpatterns.patterns.creationalPatterns.factoryMethod.notificationSystem.notification.SMSNotification

fun createNotification(type: NotificationType): Notification {
    return when (type) {
        NotificationType.SMS -> SMSNotification()
        NotificationType.Email -> EmailNotification()
        NotificationType.Push -> PushNotification()
    }
}