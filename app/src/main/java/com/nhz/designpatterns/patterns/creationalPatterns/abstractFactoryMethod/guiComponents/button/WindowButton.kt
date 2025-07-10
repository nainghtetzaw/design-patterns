package com.nhz.designpatterns.patterns.creationalPatterns.abstractFactoryMethod.guiComponents.button

class WindowButton: Button {
    override fun render() {
        println("Window button rendered.")
    }
}