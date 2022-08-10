package uk.co.twohundrerapps.analytics

import kotlinx.coroutines.flow.MutableSharedFlow
import uk.co.twohundredapps.analytics.AnalyticsEmitter
import uk.co.twohundredapps.analytics.AnalyticsObserver

internal class AnalyticsBridge<EVENT> : AnalyticsEmitter<EVENT>, AnalyticsObserver<EVENT> {
    override val events = MutableSharedFlow<EVENT>()

    override suspend fun emit(event: EVENT) {
        events.emit(event)
    }
}
