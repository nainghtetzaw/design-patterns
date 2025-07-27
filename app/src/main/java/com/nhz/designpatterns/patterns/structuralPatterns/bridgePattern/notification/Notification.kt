package com.nhz.designpatterns.patterns.structuralPatterns.bridgePattern.notification

import com.nhz.designpatterns.patterns.structuralPatterns.bridgePattern.model.NotificationContent
import com.nhz.designpatterns.patterns.structuralPatterns.bridgePattern.notificationPlatform.NotificationPlatform

interface Notification {
    val platform: NotificationPlatform
    fun send(content: NotificationContent)
    fun getType(): String
}