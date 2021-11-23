package uk.co.twohundredapps.logger

interface Logger {
    fun i(message: String)
    fun d(message: String)
    fun e(throwable: Throwable)
}
