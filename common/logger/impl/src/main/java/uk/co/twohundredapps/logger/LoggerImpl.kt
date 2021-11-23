package uk.co.twohundredapps.logger

import timber.log.Timber

internal class LoggerImpl : Logger, LoggerInitializer {

    override fun init() {
        Timber.plant(Timber.DebugTree())
    }

    override fun i(message: String) {
        Timber.i(message)
    }

    override fun d(message: String) {
        Timber.d(message)
    }

    override fun e(throwable: Throwable) {
        Timber.e(throwable)
    }
}
