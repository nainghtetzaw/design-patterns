package com.nhz.designpatterns.patterns.structuralPatterns.decoratorPattern.beverages

import com.nhz.designpatterns.patterns.structuralPatterns.decoratorPattern.Beverage

class Espresso: Beverage {
    override fun getDescription(): String {
        return "Espresso"
    }

    override fun getCost(): Double {
        return 5.0
    }
}