package com.nhz.designpatterns.patterns.creationalPatterns.abstractFactoryMethod.guiComponents.checkbox

class WindowCheckBox: CheckBox {
    override fun render() {
        println("Window checkbox rendered.")
    }
}