package uk.co.twohundrerapps.analytics

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import uk.co.twohundredapps.analytics.AnalyticsEmitter
import uk.co.twohundredapps.analytics.AnalyticsObserver

internal class AnalyticsBridge<T> : AnalyticsEmitter<T>, AnalyticsObserver<T> {
    override val events = MutableSharedFlow<T>()

    override fun emit(event: T) {
        GlobalScope.launch {
            events.emit(event)
        }
    }
}