package com.nhz.designpatterns.patterns.behavioralPatterns.observerPattern

suspend fun main() {
    val wave = basicWave {
        println( "emitting value true")
        emit(true)
    }

    wave.collect {
        println("collected value $it")
    }

    wave
        .map {

        }
        .collect {
            println("collected value $it")
        }
}