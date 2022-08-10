package uk.co.twohundredapps.analytics

import kotlin.reflect.KClass

interface AnalyticsObserverFactory {
    fun <EVENT : Any> observer(type: KClass<EVENT>): AnalyticsObserver<EVENT>
}
