package com.nhz.designpatterns.patterns.structuralPatterns.adapterPattern

import com.nhz.designpatterns.patterns.structuralPatterns.adapterPattern.paymentAdapter.PayPalPaymentAdapter
import com.nhz.designpatterns.patterns.structuralPatterns.adapterPattern.paymentAdapter.PaymentAdapter
import com.nhz.designpatterns.patterns.structuralPatterns.adapterPattern.paymentAdapter.StripePaymentAdapter

sealed interface PaymentCustomerData {
    data class Paypal(val customerEmail: String): PaymentCustomerData
    data class Stripe(val customerToken: String): PaymentCustomerData
}

class PaymentFactory {
    companion object {
        enum class Method {
            STRIPE, PAYPAL
        }
    }

    private var adapter: PaymentAdapter? = null

    private fun init(method: Method) {
        adapter = when(method) {
            Method.STRIPE -> StripePaymentAdapter()
            Method.PAYPAL -> PayPalPaymentAdapter()
        }
    }

    private fun clear() {
        adapter = null
    }

    fun makePayment(
        method: Method,
        amount: Double,
        currency: Currency.Data,
        customerData: PaymentCustomerData
    ): PaymentResult {
        init(method)
        return adapter!!.makePayment(amount, currency, customerData)
            .also { clear() }
    }
}