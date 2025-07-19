package com.nhz.designpatterns.patterns.structuralPatterns.adapterPattern.paymentAdapter

import com.nhz.designpatterns.patterns.structuralPatterns.adapterPattern.Currency
import com.nhz.designpatterns.patterns.structuralPatterns.adapterPattern.PaymentCustomerData
import com.nhz.designpatterns.patterns.structuralPatterns.adapterPattern.PaymentResult

interface PaymentAdapter {
    fun makePayment(amount: Double, currency: Currency.Data, customerData: PaymentCustomerData): PaymentResult
}