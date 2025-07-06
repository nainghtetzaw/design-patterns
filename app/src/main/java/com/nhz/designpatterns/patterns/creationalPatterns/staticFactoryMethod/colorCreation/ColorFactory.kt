package com.nhz.designpatterns.patterns.creationalPatterns.staticFactoryMethod.colorCreation

import androidx.annotation.ColorLong
import androidx.annotation.FloatRange
import androidx.annotation.IntRange
import androidx.compose.ui.graphics.Color
import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red

class ColorFactory private constructor(){
    companion object {
        private var cache: Array<Color> = arrayOf()

        private fun saveColor(value: Color) {
            cache = cache.plusElement(value)
        }

        private fun getCache(
            @FloatRange(0.0, 1.0) r: Float,
            @FloatRange(0.0, 1.0) g: Float,
            @FloatRange(0.0, 1.0) b: Float
        ): Color? {
            return cache.firstOrNull {
                value -> value.red == r && value.green == g && value.blue == b
            }
        }

        private fun Int.asColorFloat(): Float {
            require(this in 0..255)
            return (this.toDouble() * 0.003921568627).toFloat()
        }

        private fun getCache(@ColorLong value: Int): Color? {
            return cache.firstOrNull {
                it.red == value.red.asColorFloat()
                        && it.green == value.green.asColorFloat()
                        && it.blue == value.blue.asColorFloat()
            }
        }

        fun fromRGB(
            @IntRange(0, 255) r: Int,
            @IntRange(0, 255) g: Int,
            @IntRange(0, 255) b: Int
        ): Color {
            val cacheColor = getCache(r.asColorFloat(), g.asColorFloat(), b.asColorFloat())

            if (cacheColor == null) {
                val color = Color(r, g, b)
                saveColor(color)
                return color
            }

            return cacheColor
        }

        fun fromColorCode(@ColorLong color: Long): Color {
            val cacheColor = getCache(color.toInt())

            if (cacheColor == null) {
                val newColor = Color(color)
                saveColor(newColor)
                return newColor
            }

            return cacheColor
        }

        fun black(): Color {
            val colorInt = 0x00000000
            val cacheColor = getCache(colorInt)

            println(cache.toList())

            if (cacheColor == null) {
                val color = Color.Black
                saveColor(color)
                return color
            }

            return cacheColor
        }

        fun white(): Color {
            val colorInt: Int = (0xFFFFFFFF).toInt()
            val cacheColor = getCache(colorInt)

            if (cacheColor == null) {
                val color = Color.White

                saveColor(color)
                return color
            }

            return cacheColor
        }
    }
}