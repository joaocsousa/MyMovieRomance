package uk.co.twohundrerapps.analytics

import uk.co.twohundredapps.analytics.AnalyticsEmitter
import uk.co.twohundredapps.analytics.AnalyticsEmitterFactory
import uk.co.twohundredapps.analytics.AnalyticsObserver
import uk.co.twohundredapps.analytics.AnalyticsObserverFactory
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.reflect.KClass

@Singleton
internal class AnalyticsBridgeFactory @Inject constructor() : AnalyticsEmitterFactory, AnalyticsObserverFactory {
    private val bridges = mutableMapOf<KClass<*>, AnalyticsBridge<*>>()

    @Suppress("UNCHECKED_CAST")
    override fun <EVENT : Any> emitter(type: KClass<EVENT>): AnalyticsEmitter<EVENT> {
        return bridges.getOrPut(type) {
            AnalyticsBridge<EVENT>()
        } as AnalyticsEmitter<EVENT>
    }

    @Suppress("UNCHECKED_CAST")
    override fun <EVENT : Any> observer(type: KClass<EVENT>): AnalyticsObserver<EVENT> {
        return bridges.getOrPut(type) {
            AnalyticsBridge<EVENT>()
        } as AnalyticsObserver<EVENT>
    }
}
