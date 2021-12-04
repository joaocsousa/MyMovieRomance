package uk.co.twohundredapps.logger

import android.util.Log
import java.util.logging.Handler
import java.util.logging.Level
import java.util.logging.LogRecord

internal class AndroidLogHandler : Handler() {

    private val Level.androidLevel: Int
        get() = when (intValue()) {
            Level.SEVERE.intValue() -> Log.ERROR
            Level.WARNING.intValue() -> Log.WARN
            Level.INFO.intValue() -> Log.INFO
            Level.FINE.intValue() -> Log.DEBUG
            else -> Log.DEBUG
        }

    override fun publish(record: LogRecord) {
        val tag = record.loggerName
        val message = record.thrown?.let { thrown ->
            "${record.message}: ${Log.getStackTraceString(thrown)}"
        } ?: record.message

        Log.println(record.level.androidLevel, tag, message)
    }

    override fun flush() {
        // no-op
    }

    override fun close() {
        // no-op
    }
}