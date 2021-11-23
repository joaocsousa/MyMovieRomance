package uk.co.twohundredapps.configuration.data.network

import uk.co.twohundredapps.api.NotCachedException
import uk.co.twohundredapps.configuration.data.network.models.`in`.Configuration

internal interface ConfigurationMemoryDataSource : ConfigurationDataSource {
    fun setConfiguration(configuration: Configuration)
}

internal class ConfigurationMemoryDataSourceImpl : ConfigurationMemoryDataSource {

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
