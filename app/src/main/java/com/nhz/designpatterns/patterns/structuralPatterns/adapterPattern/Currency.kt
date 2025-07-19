package com.nhz.designpatterns.patterns.structuralPatterns.adapterPattern

object Currency {
    data class Data(
        val currencyCode: String,
        val currencySymbol: String
    )

    private enum class CurrencyCode {
        USD, SGD, THB
    }

    private val hashmap: HashMap<String, Data> = hashMapOf(
        CurrencyCode.USD.name to Data(currencyCode = CurrencyCode.USD.name, currencySymbol = "$"),
        CurrencyCode.SGD.name to Data(currencyCode = CurrencyCode.SGD.name, currencySymbol = "S$"),
        CurrencyCode.THB.name to Data(currencyCode = CurrencyCode.THB.name, currencySymbol = "฿")
    )

    val USD = hashmap[CurrencyCode.USD.name]!!
    val SGD = hashmap[CurrencyCode.SGD.name]!!
    val THB = hashmap[CurrencyCode.THB.name]!!

    fun getCurrencyBySymbol(symbol: String): Data {
        val result = hashmap.values.firstOrNull { it.currencySymbol.lowercase() == symbol.lowercase() }
        requireNotNull(result) { "No matching currency found by the given symbol $symbol!" }
        return result
    }

    fun getCurrencyByCode(code: String): Data {
        val result = hashmap[code]
        requireNotNull(result) { "No matching currency found by the given code $code!" }
        return result
    }
}