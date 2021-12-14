package uk.co.twohundredapps.analytics

/**
 * Should not be here. It's here just for demo
 */
sealed interface HomeEvent {
    data class Displayed(val timestamp: Long) : HomeEvent
}