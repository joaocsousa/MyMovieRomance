package uk.co.twohundredapps.logger

interface Logger {
    fun init()
    fun i(message: String)
    fun d(message: String)
    fun e(throwable: Throwable)
}
