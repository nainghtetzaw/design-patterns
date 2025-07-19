package com.nhz.designpatterns.patterns.structuralPatterns.adapterPattern.paymentAdapter

import com.nhz.designpatterns.patterns.structuralPatterns.adapterPattern.Currency
import com.nhz.designpatterns.patterns.structuralPatterns.adapterPattern.PaymentCustomerData
import com.nhz.designpatterns.patterns.structuralPatterns.adapterPattern.PaymentResult
import com.nhz.designpatterns.patterns.structuralPatterns.adapterPattern.paymentProvider.StripeAPI
import com.nhz.designpatterns.patterns.structuralPatterns.adapterPattern.paymentProvider.StripePaymentResult
import java.math.BigDecimal
import java.math.RoundingMode

class StripePaymentAdapter(private val api: StripeAPI = StripeAPI()): PaymentAdapter {
    private fun Double.toCents(): Int {
        return BigDecimal(this.toString())
            .multiply(BigDecimal(100))
            .setScale(0, RoundingMode.HALF_UP)
            .toInt()
    }

    private fun Int.toDollar(): Double {
        return BigDecimal(this)
            .divide(BigDecimal(100), 2, RoundingMode.HALF_UP)
            .toDouble()
    }

    override fun makePayment(
        amount: Double,
        currency: Currency.Data,
        customerData: PaymentCustomerData
    ): PaymentResult {
        require(customerData is PaymentCustomerData.Stripe) {
            "Stripe payment requires customer token!"
        }

        val customerToken = customerData.customerToken
        return when (val result = api.charge(amount.toCents(), currency.currencyCode, customerToken)) {
            is StripePaymentResult.Error -> PaymentResult.Error(result.message)
            is StripePaymentResult.Success -> PaymentResult.Success(
                status = result.status,
                amount = result.amountInCents.toDollar(),
                currency = Currency.getCurrencyByCode(result.currencyCode)
            )
        }
    }
}