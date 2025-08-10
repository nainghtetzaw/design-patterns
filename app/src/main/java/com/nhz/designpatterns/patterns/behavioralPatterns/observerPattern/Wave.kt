package com.nhz.designpatterns.patterns.behavioralPatterns.observerPattern

interface Wave <out T> {
    suspend fun collect(collector: WaveCollector<T>)
}

fun <T> basicWave(block: suspend WaveCollector<T>.() -> Unit): Wave<T> {
    return BasicWave(block)
}

//fun <T, R> Wave<T>.map(transform: (T) -> R): Wave<T> {
//    return MapWave<R>(transform)
//}

suspend fun <T> Wave<T>.collect(block: suspend (T) -> Unit) {
    val collector = BasicWaveCollector(block)
    this.collect(collector)
}

private class BasicWave <T> (
    private val block: suspend WaveCollector<T>.() -> Unit
): Wave<T> {
    override suspend fun collect(collector: WaveCollector<T>) {
        block(collector)
    }
}

//private class MapWave <R> (
//    private val transform: WaveCollector<R>.() -> Unit
//): Wave<R> {
//    override suspend fun collect(collector: WaveCollector<R>) {
//        transform(collector)
//    }
//}





