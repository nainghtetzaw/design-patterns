package com.nhz.designpatterns.patterns.structuralPatterns.bridgePattern.notification

import com.nhz.designpatterns.patterns.structuralPatterns.bridgePattern.model.NotificationContent
import com.nhz.designpatterns.patterns.structuralPatterns.bridgePattern.notificationPlatform.NotificationPlatform

class SmsNotification(override val platform: NotificationPlatform): Notification {
    override fun send(content: NotificationContent) {
        platform.sendNotification(content)
    }

    override fun getType(): String {
        return "sms"
    }
}