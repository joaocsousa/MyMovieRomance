package uk.co.twohundredapps.configuration.data.network

import uk.co.twohundredapps.api.NotCachedException
import uk.co.twohundredapps.configuration.data.network.models.`in`.Configuration
import javax.inject.Inject
import javax.inject.Singleton

internal interface ConfigurationMemoryDataSource : ConfigurationDataSource {
    fun setConfiguration(configuration: Configuration)
}

@Singleton
internal class ConfigurationMemoryDataSourceImpl @Inject constructor() : ConfigurationMemoryDataSource {

    private var configuration: Configuration? = null

    override fun setConfiguration(configuration: Configuration) {
        this.configuration = configuration
    }

    override suspend fun getConfiguration(): Result<Configuration> {
        return runCatching {
            if (configuration != null) {
                configuration!!
            } else {
                throw NotCachedException("configuration not cached")
            }
        }
    }
}
