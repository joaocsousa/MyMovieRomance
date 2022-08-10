package uk.co.twohundredapps.analytics

interface AnalyticsEmitter<EVENT> {
    suspend fun emit(event: EVENT)
}
