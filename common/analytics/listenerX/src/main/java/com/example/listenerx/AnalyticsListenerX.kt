package com.example.listenerx

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import uk.co.twohundredapps.analytics.AnalyticsInitializer
import uk.co.twohundredapps.analytics.AnalyticsObserverFactory
import uk.co.twohundredapps.logger.coreLogger
import uk.co.twohundrerapps.analytics.HomeEvent
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class AnalyticsListenerX @Inject constructor(
    private val analyticsObserverFactory: AnalyticsObserverFactory,
) : AnalyticsInitializer {
    private val applicationScope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

    override fun initialize() {
        applicationScope.launch {
            analyticsObserverFactory.observer(HomeEvent::class).events.collect { event ->
                coreLogger.w("NEW EVENT $event")
                // log to firebase, branch, braze, whatever
            }
        }
    }
}
