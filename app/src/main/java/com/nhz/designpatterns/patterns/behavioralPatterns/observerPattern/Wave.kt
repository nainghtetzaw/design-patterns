package com.nhz.designpatterns.patterns.behavioralPatterns.observerPattern

interface Wave <out T> {
    suspend fun collect(collector: WaveCollector<T>)
}

fun <T> basicWave(block: suspend WaveCollector<T>.() -> Unit): Wave<T> {
    return BasicWave(block)
}

fun <T, R> Wave<T>.map(transform: (T) -> R): Wave<R> {
    return MapWave(this, transform)
}

suspend fun <T> Wave<T>.collect(block: suspend (T) -> Unit) {
    val collector = BasicWaveCollector(block)
    this.collect(collector)
}

private class BasicWave <T> (
    private val action: suspend WaveCollector<T>.() -> Unit
): Wave<T> {
    override suspend fun collect(collector: WaveCollector<T>) {
        action(collector)
    }
}

private class MapWave <in T, out R> (
    private val upstream: Wave<T>,
    private val transform: (T) -> R
): Wave<R> {
    override suspend fun collect(collector: WaveCollector<R>) {
        upstream.collect {
            collector.emit(transform(it))
        }
    }
}

