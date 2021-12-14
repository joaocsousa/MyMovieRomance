package uk.co.twohundredapps.analytics

import kotlin.reflect.KClass

interface AnalyticsEmitterFactory {
    fun <T : Any> emitter(type: KClass<T>): AnalyticsEmitter<T>
}
