package uk.co.twohundredapps.mymovieromance.infrastructure.config

import uk.co.twohundredapps.infrastructure.config.BuildConfigProvider
import uk.co.twohundredapps.mymovieromance.BuildConfig

class BuildConfigProviderImpl : BuildConfigProvider {
    override val isDebug: Boolean
        get() = BuildConfig.DEBUG
    override val apiKey: String
        get() = BuildConfig.API_KEY
}
