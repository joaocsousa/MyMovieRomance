package uk.co.twohundredapps.logger

import java.util.logging.Level
import java.util.logging.Logger

val logy: Logy
    get() = InternalLogger(logger = Logger.getAnonymousLogger())

val Any.logy: Logy
    get() = InternalLogger(logger = Logger.getLogger(this@logy::class.java.simpleName))

private class InternalLogger(
    private val logger: Logger,
) : Logy {
    override fun d(message: String) {
        logger.log(Level.FINE, message)
    }

    override fun i(message: String) {
        logger.log(Level.INFO, message)
    }

    override fun w(message: String) {
        logger.log(Level.WARNING, message)
    }

    override fun e(message: String) {
        logger.log(Level.SEVERE, message)
    }

    override fun e(throwable: Throwable, message: String) {
        logger.log(Level.SEVERE, message, throwable)
    }
}
