package uk.co.twohundredapps.logger

import java.util.logging.Handler
import java.util.logging.LogRecord

internal class NoopLogger : Handler() {

    override fun publish(record: LogRecord) {
        // no-op
    }

    override fun flush() {
        // no-op
    }

    override fun close() {
        // no-op
    }
}