package uk.co.twohundredapps.analytics

import kotlin.reflect.KClass

interface AnalyticsObserverFactory {
    fun <T : Any> observer(type: KClass<T>): AnalyticsObserver<T>
}