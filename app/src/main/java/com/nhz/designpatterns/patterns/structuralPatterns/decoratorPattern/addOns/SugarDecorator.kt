package com.nhz.designpatterns.patterns.structuralPatterns.decoratorPattern.addOns

import com.nhz.designpatterns.patterns.structuralPatterns.decoratorPattern.Beverage
import com.nhz.designpatterns.patterns.structuralPatterns.decoratorPattern.BeverageDecorator

class SugarDecorator(beverage: Beverage): BeverageDecorator(beverage) {
    private val cost = 0.25
    private val description = "Sugar"

    override fun getCost(): Double {
        return super.getCost() + cost
    }

    override fun getDescription(): String {
        return super.getDescription() + " + $description"
    }
}