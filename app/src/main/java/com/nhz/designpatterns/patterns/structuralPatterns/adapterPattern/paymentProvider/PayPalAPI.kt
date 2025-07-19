package com.nhz.designpatterns.patterns.structuralPatterns.adapterPattern.paymentProvider

sealed interface PayPalPaymentResult {
    data class Success(
        val status: String,
        val amount: Double,
        val currencySymbol: String,
        val customerEmail: String
    ): PayPalPaymentResult

    data class Error(
        val code: Int,
        val message: String
    ): PayPalPaymentResult
}

class PayPalAPI {
    fun makePayment(amount: Double, currencySymbol: String, customerEmail: String): PayPalPaymentResult {
        if (amount < 0) {
            return PayPalPaymentResult.Error(
                code = 120,
                message = "Amount should not be negative."
            )
        }

        if (currencySymbol.isEmpty() || customerEmail.isEmpty()) {
            return PayPalPaymentResult.Error(
                code = 144,
                message = "Currency or customer email should not be empty."
            )
        }

        return PayPalPaymentResult.Success(
            status = "Paid",
            amount = amount,
            currencySymbol = currencySymbol,
            customerEmail = customerEmail
        )
    }
}