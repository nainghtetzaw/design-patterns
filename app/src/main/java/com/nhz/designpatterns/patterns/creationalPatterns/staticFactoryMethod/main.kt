package com.nhz.designpatterns.patterns.creationalPatterns.staticFactoryMethod

import com.nhz.designpatterns.patterns.creationalPatterns.staticFactoryMethod.colorCreation.ColorFactory

fun main() {
    val colorFactory = ColorFactory.fromColorCode(0xFFDA61)
    val whiteColorFactory = ColorFactory.fromRGB(255, 218, 97)
}