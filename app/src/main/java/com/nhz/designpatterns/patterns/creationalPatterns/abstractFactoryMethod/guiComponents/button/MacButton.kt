package com.nhz.designpatterns.patterns.creationalPatterns.abstractFactoryMethod.guiComponents.button

class MacButton: Button {
    override fun render() {
        println("Mac button rendered.")
    }
}