package com.nhz.designpatterns.patterns.structuralPatterns.adapterPattern.paymentProvider

sealed interface StripePaymentResult {
    data class Success(
        val status: String,
        val amountInCents: Int,
        val currencyCode: String
    ): StripePaymentResult

    data class Error(
        val code: Int,
        val message: String
    ): StripePaymentResult
}

class StripeAPI {
    fun charge(amountInCents: Int, currencyCode: String, customerToken: String): StripePaymentResult {
        if (amountInCents < 0) {
            return StripePaymentResult.Error(
                code = 120,
                message = "Amount should not be negative."
            )
        }

        if (currencyCode.isEmpty() || customerToken.isEmpty()) {
            return StripePaymentResult.Error(
                code = 121,
                message = "Currency code or customer token should not be empty."
            )
        }

        return StripePaymentResult.Success(
            status = "Paid",
            amountInCents = amountInCents,
            currencyCode = currencyCode
        )
    }
}