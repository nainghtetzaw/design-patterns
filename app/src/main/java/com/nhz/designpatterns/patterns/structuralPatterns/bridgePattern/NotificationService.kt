package com.nhz.designpatterns.patterns.structuralPatterns.bridgePattern

import com.nhz.designpatterns.patterns.structuralPatterns.bridgePattern.model.EmailNotificationContent
import com.nhz.designpatterns.patterns.structuralPatterns.bridgePattern.model.NotificationContent
import com.nhz.designpatterns.patterns.structuralPatterns.bridgePattern.model.PushNotificationContent
import com.nhz.designpatterns.patterns.structuralPatterns.bridgePattern.model.SmsNotificationContent
import com.nhz.designpatterns.patterns.structuralPatterns.bridgePattern.notification.EmailNotification
import com.nhz.designpatterns.patterns.structuralPatterns.bridgePattern.notification.Notification
import com.nhz.designpatterns.patterns.structuralPatterns.bridgePattern.notification.PhoneNotification
import com.nhz.designpatterns.patterns.structuralPatterns.bridgePattern.notification.SmsNotification
import com.nhz.designpatterns.patterns.structuralPatterns.bridgePattern.notificationPlatform.AndroidNotificationPlatform
import com.nhz.designpatterns.patterns.structuralPatterns.bridgePattern.notificationPlatform.IOSNotificationPlatform
import com.nhz.designpatterns.patterns.structuralPatterns.bridgePattern.notificationPlatform.NotificationPlatform
import com.nhz.designpatterns.patterns.structuralPatterns.bridgePattern.notificationPlatform.WebNotificationPlatform

class NotificationService() {
    private fun String.getPlatform(): NotificationPlatform {
        return when(this.lowercase()) {
            "android" -> AndroidNotificationPlatform()
            "ios" -> IOSNotificationPlatform()
            else -> WebNotificationPlatform()
        }
    }

    private fun String.getNotification(platForm: NotificationPlatform): Notification {
        return when(this.lowercase()) {
            "email" -> EmailNotification(platForm)
            "sms" -> SmsNotification(platForm)
            else -> PhoneNotification(platForm)
        }
    }

    fun send(
        platForm: String,
        notificationType: String,
        title: String,
        message: String,
        email: String = "",
        phone: String = ""
    ) {
        val notificationPlatform = platForm.getPlatform()
        val notification = notificationType.getNotification(notificationPlatform)
        val content: NotificationContent = when (notificationType) {
            "email" -> {
                require(email.isNotEmpty()) { "Email should not be empty to send email." }
                EmailNotificationContent(
                    title = title,
                    body = message,
                    recipientEmail = email
                )
            }
            "sms" -> {
                require(phone.isNotEmpty()) { "Phone number should not be empty to send SMS." }
                SmsNotificationContent(
                    title = title,
                    body = message,
                    phoneNumber = phone
                )
            }
            else -> PushNotificationContent(title, message)
        }

        notification.send(content)
    }
}