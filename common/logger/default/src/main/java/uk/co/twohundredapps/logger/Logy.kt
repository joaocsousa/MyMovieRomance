package uk.co.twohundredapps.logger

interface Logy {
    fun d(message: String)
    fun i(message: String)
    fun w(message: String)
    fun e(message: String)
    fun e(throwable: Throwable, message: String)
}