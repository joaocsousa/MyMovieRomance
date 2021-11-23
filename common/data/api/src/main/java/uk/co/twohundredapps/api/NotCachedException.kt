package uk.co.twohundredapps.api

data class NotCachedException(override val message: String) : IllegalStateException(message)
