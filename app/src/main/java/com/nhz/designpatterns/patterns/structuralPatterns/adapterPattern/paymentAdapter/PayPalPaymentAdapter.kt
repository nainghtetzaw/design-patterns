package com.nhz.designpatterns.patterns.structuralPatterns.adapterPattern.paymentAdapter

import com.nhz.designpatterns.patterns.structuralPatterns.adapterPattern.Currency
import com.nhz.designpatterns.patterns.structuralPatterns.adapterPattern.PaymentCustomerData
import com.nhz.designpatterns.patterns.structuralPatterns.adapterPattern.PaymentResult
import com.nhz.designpatterns.patterns.structuralPatterns.adapterPattern.paymentProvider.PayPalAPI
import com.nhz.designpatterns.patterns.structuralPatterns.adapterPattern.paymentProvider.PayPalPaymentResult

class PayPalPaymentAdapter(private val api: PayPalAPI = PayPalAPI()): PaymentAdapter {
    override fun makePayment(
        amount: Double,
        currency: Currency.Data,
        customerData: PaymentCustomerData
    ): PaymentResult {
        require(customerData is PaymentCustomerData.Paypal) { "PayPal payment requires customer email!" }

        val customerEmail = customerData.customerEmail
        return when (val result = api.makePayment(amount, currency.currencySymbol, customerEmail)) {
            is PayPalPaymentResult.Error -> PaymentResult.Error(result.message)
            is PayPalPaymentResult.Success -> PaymentResult.Success(
                status = result.status,
                amount = result.amount,
                currency = Currency.getCurrencyBySymbol(result.currencySymbol),
                customerEmail = result.customerEmail
            )
        }
    }
}