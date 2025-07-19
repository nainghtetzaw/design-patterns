package com.nhz.designpatterns.patterns.structuralPatterns.adapterPattern

fun main() {
    val paymentFactory = PaymentFactory()

    println("" +
            "${
                paymentFactory.makePayment(
                    method = PaymentFactory.Companion.Method.STRIPE,
                    amount = 1.5,
                    currency = Currency.USD,
                    customerData = PaymentCustomerData.Stripe("token_customer")
                )
            }"
    )
}