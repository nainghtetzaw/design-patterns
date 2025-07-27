package com.nhz.designpatterns.patterns.structuralPatterns.bridgePattern.notificationPlatform

import com.nhz.designpatterns.patterns.structuralPatterns.bridgePattern.model.NotificationContent

interface NotificationPlatform {
    fun sendNotification(notificationContent: NotificationContent)
    fun getPlatform(): String
}

fun NotificationPlatform.printRichLog(content: NotificationContent) {
    println(
        "---   Sent ${getPlatform()} notification   ---\n" +
                "type: ${content.type}\n" +
                "title: ${content.title}\n" +
                "body: ${content.body}\n" +
                "---   End message   ---"
    )
}