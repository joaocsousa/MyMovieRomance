package uk.co.twohundredapps.logger

internal class NoopLogger : Logger, LoggerInitializer {

    override fun init() {
        // no-op
    }

    override fun i(message: String) {
        // no-op
    }

    override fun d(message: String) {
        // no-op
    }

    override fun e(throwable: Throwable) {
        // no-op
    }
}
