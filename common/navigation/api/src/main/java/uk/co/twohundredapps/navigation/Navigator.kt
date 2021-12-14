package uk.co.twohundredapps.navigation

import kotlinx.coroutines.flow.Flow

interface Navigator {
    val events: Flow<Destination>
    fun navigateTo(destination: Destination)
}
