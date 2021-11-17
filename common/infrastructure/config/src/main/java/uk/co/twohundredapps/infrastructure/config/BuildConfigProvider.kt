package uk.co.twohundredapps.infrastructure.config

interface BuildConfigProvider {
    val isDebug: Boolean
    val apiKey: String
}
