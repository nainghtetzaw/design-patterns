package com.nhz.designpatterns.patterns.creationalPatterns.abstractFactoryMethod.guiComponents

import com.nhz.designpatterns.patterns.creationalPatterns.abstractFactoryMethod.guiComponents.button.Button
import com.nhz.designpatterns.patterns.creationalPatterns.abstractFactoryMethod.guiComponents.button.LinuxButton
import com.nhz.designpatterns.patterns.creationalPatterns.abstractFactoryMethod.guiComponents.button.MacButton
import com.nhz.designpatterns.patterns.creationalPatterns.abstractFactoryMethod.guiComponents.button.WindowButton
import com.nhz.designpatterns.patterns.creationalPatterns.abstractFactoryMethod.guiComponents.checkbox.CheckBox
import com.nhz.designpatterns.patterns.creationalPatterns.abstractFactoryMethod.guiComponents.checkbox.LinuxCheckbox
import com.nhz.designpatterns.patterns.creationalPatterns.abstractFactoryMethod.guiComponents.checkbox.MacCheckbox
import com.nhz.designpatterns.patterns.creationalPatterns.abstractFactoryMethod.guiComponents.checkbox.WindowCheckBox

interface GUIComponents {
    fun createButton(): Button
    fun createCheckBox(): CheckBox
}

class WindowFactory: GUIComponents {
    override fun createButton(): Button {
        return WindowButton()
    }

    override fun createCheckBox(): CheckBox {
        return WindowCheckBox()
    }
}

class MacFactory: GUIComponents {
    override fun createButton(): Button {
        return MacButton()
    }

    override fun createCheckBox(): CheckBox {
        return MacCheckbox()
    }
}

class LinuxFactory: GUIComponents {
    override fun createCheckBox(): CheckBox {
        return LinuxCheckbox()
    }

    override fun createButton(): Button {
        return LinuxButton()
    }
}