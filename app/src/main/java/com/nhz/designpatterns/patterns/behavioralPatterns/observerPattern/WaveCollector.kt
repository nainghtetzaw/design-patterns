package com.nhz.designpatterns.patterns.behavioralPatterns.observerPattern

interface WaveCollector <in T> {
    suspend fun emit(value: T)
}

class BasicWaveCollector<T>(
    private val action: suspend (T) -> Unit
): WaveCollector<T> {
    override suspend fun emit(value: T) {
        action(value)
    }
}

