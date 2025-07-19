package com.nhz.designpatterns.patterns.structuralPatterns.adapterPattern

sealed interface PaymentResult {
    data class Success(
        val status: String,
        val amount: Double,
        val currency: Currency.Data,
        val customerEmail: String = ""
    ): PaymentResult

    data class Error(
        val message: String
    ): PaymentResult
}