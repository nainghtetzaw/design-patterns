package com.nhz.designpatterns.patterns.structuralPatterns.bridgePattern.notificationPlatform

import com.nhz.designpatterns.patterns.structuralPatterns.bridgePattern.model.NotificationContent

class AndroidNotificationPlatform: NotificationPlatform {
    override fun sendNotification(notificationContent: NotificationContent) {
        printRichLog(notificationContent)
    }

    override fun getPlatform(): String {
        return "android"
    }
}