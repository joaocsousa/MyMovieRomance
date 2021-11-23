package uk.co.twohundredapps.logger

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import uk.co.twohundredapps.logger.Logger

object Logy : KoinComponent, Logger {
    private val logger by inject<Logger>()

    override fun i(message: String) {
        logger.i(message)
    }

    override fun d(message: String) {
        logger.d(message)
    }

    override fun e(throwable: Throwable) {
        logger.e(throwable)
    }
}
