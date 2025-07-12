package com.nhz.designpatterns.patterns.structuralPatterns.decoratorPattern.addOns

import com.nhz.designpatterns.patterns.structuralPatterns.decoratorPattern.Beverage
import com.nhz.designpatterns.patterns.structuralPatterns.decoratorPattern.BeverageDecorator
import com.nhz.designpatterns.patterns.structuralPatterns.decoratorPattern.beverages.Espresso

class MilkDecorator(beverage: Beverage): BeverageDecorator(beverage) {
    private val cost = 0.5
    private val description = "Milk"

    override fun getCost(): Double {
        return super.getCost() + cost
    }

    override fun getDescription(): String {
        return super.getDescription() + " + $description"
    }
}