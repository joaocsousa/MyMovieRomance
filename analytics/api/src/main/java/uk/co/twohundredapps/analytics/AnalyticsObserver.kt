package uk.co.twohundredapps.analytics

import kotlinx.coroutines.flow.Flow

interface AnalyticsObserver<EVENT> {
    val events: Flow<EVENT>
}