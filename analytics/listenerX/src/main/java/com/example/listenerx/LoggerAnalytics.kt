package com.example.listenerx

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import uk.co.twohundredapps.analytics.AnalyticsInitializer
import uk.co.twohundredapps.analytics.AnalyticsObserverFactory
import uk.co.twohundredapps.analytics.HomeEvent
import uk.co.twohundredapps.logger.coreLogger
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class LoggerAnalytics @Inject constructor(
    private val analyticsObserverFactory: AnalyticsObserverFactory,
) : AnalyticsInitializer {
    override fun initialize() {
        coreLogger.w("INITIALIZED ${analyticsObserverFactory.observer(HomeEvent::class).events}")

        GlobalScope.launch {
            analyticsObserverFactory.observer(HomeEvent::class).events.collect { event ->
                coreLogger.w("NEW EVENT $event")
            }
        }
    }
}