package uk.co.twohundredapps.logger

import uk.co.twohundrerapps.logger.LoggerInitializer
import javax.inject.Inject

internal class NoOpInitializer @Inject constructor() : LoggerInitializer {
    override fun initialize() {
        // no-op
    }
}
