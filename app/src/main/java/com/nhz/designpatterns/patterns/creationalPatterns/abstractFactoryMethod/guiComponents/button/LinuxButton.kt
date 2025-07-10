package com.nhz.designpatterns.patterns.creationalPatterns.abstractFactoryMethod.guiComponents.button

class LinuxButton: Button {
    override fun render() {
        println("Linus button rendered.")
    }
}