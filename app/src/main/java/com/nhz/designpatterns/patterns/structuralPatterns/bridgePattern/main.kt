package com.nhz.designpatterns.patterns.structuralPatterns.bridgePattern

fun main() {
    val service = NotificationService()

    service.send(
        platForm = "ios",
        notificationType = "sms",
        title = "Sending iOS SMS noti!",
        message = "Hello!",
        phone = "0612345678"
    )
}