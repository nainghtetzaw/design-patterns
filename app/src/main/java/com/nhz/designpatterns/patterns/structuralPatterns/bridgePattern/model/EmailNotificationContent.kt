package com.nhz.designpatterns.patterns.structuralPatterns.bridgePattern.model

data class EmailNotificationContent(
    override val title: String,
    override val body: String,
    val recipientEmail: String
): NotificationContent {
    override val type: String
        get() = "email"
}
