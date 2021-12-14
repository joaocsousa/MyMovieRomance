package uk.co.twohundrerapps.analytics

import uk.co.twohundredapps.analytics.AnalyticsEmitter
import uk.co.twohundredapps.analytics.AnalyticsEmitterFactory
import uk.co.twohundredapps.analytics.AnalyticsObserver
import uk.co.twohundredapps.analytics.AnalyticsObserverFactory
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.reflect.KClass

@Singleton
internal class AnalyticsBridgeProviderImpl @Inject constructor() : AnalyticsEmitterFactory, AnalyticsObserverFactory {
    private val bridges = mutableMapOf<KClass<*>, AnalyticsBridge<*>>()

    @Suppress("UNCHECKED_CAST")
    override fun <T : Any> emitter(type: KClass<T>): AnalyticsEmitter<T> {
        return bridges.getOrPut(type, {
            AnalyticsBridge<T>()
        }) as AnalyticsEmitter<T>
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : Any> observer(type: KClass<T>): AnalyticsObserver<T> {
        return bridges.getOrPut(type, {
            AnalyticsBridge<T>()
        }) as AnalyticsObserver<T>
    }
}
