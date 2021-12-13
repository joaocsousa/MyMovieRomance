package uk.co.twohundredapps.logger

import java.util.logging.Level
import java.util.logging.Logger

interface CoreLogger {
    fun d(message: String)
    fun i(message: String)
    fun w(message: String)
    fun e(message: String)
    fun e(throwable: Throwable, message: String)
}

val Any.coreLogger: CoreLogger
    get() = object : CoreLogger {
        private val logger = Logger.getLogger(this@coreLogger::class.java.simpleName)
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
