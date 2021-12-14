package uk.co.twohundredapps.navigation

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class NavigatorImpl @Inject constructor() : Navigator {
    override val events = MutableSharedFlow<Destination>()

    override fun navigateTo(destination: Destination) {
        GlobalScope.launch {
            events.emit(destination)
        }
    }
}
