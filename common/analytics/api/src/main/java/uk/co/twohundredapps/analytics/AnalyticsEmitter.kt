package uk.co.twohundredapps.analytics

interface AnalyticsEmitter<EVENT> {
    fun emit(event: EVENT)
}
