package com.nhz.designpatterns.patterns.structuralPatterns.bridgePattern.model

data class SmsNotificationContent(
    override val title: String,
    override val body: String,
    val phoneNumber: String
): NotificationContent {
    override val type: String
        get() = "sms"
}
