package uk.co.twohundredapps.analytics

import kotlin.reflect.KClass

interface AnalyticsEmitterFactory {
    fun <EVENT : Any> emitter(type: KClass<EVENT>): AnalyticsEmitter<EVENT>
}
