package com.nhz.designpatterns.patterns.structuralPatterns.decoratorPattern

import com.nhz.designpatterns.patterns.structuralPatterns.decoratorPattern.addOns.MilkDecorator
import com.nhz.designpatterns.patterns.structuralPatterns.decoratorPattern.addOns.SugarDecorator
import com.nhz.designpatterns.patterns.structuralPatterns.decoratorPattern.beverages.Espresso

fun main() {
    val espresso = Espresso()
    val milk = MilkDecorator(espresso)
    val sugar = SugarDecorator(milk)

    println("totalPrice = ${sugar.getCost()}")
    println("description = ${sugar.getDescription()}")
}