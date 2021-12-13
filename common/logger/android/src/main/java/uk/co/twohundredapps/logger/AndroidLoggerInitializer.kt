package uk.co.twohundredapps.logger

import uk.co.twohundrerapps.logger.LoggerInitializer
import java.util.logging.Handler
import java.util.logging.Level
import java.util.logging.Logger
import javax.inject.Inject

internal class AndroidLoggerInitializer @Inject constructor(
    private val androidLogHandler: Handler,
) : LoggerInitializer {
    override fun initialize() {
        Logger.getLogger("").apply {
            level = Level.ALL
            handlers.forEach { removeHandler(it) }
            addHandler(androidLogHandler)
        }
    }
}
