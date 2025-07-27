package com.nhz.designpatterns.patterns.structuralPatterns.bridgePattern.model

data class PushNotificationContent(
    override val title: String,
    override val body: String,
): NotificationContent {
    override val type: String
        get() = "push"
}
