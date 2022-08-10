package uk.co.twohundredapps.configuration.data.network

import uk.co.twohundredapps.api.NotCachedException
import uk.co.twohundredapps.configuration.data.network.models.`in`.ConfigurationApiJson
import javax.inject.Inject
import javax.inject.Singleton

internal interface ConfigurationMemoryDataSource : ConfigurationDataSource {
    fun setConfiguration(configuration: ConfigurationApiJson)
}

@Singleton
internal class ConfigurationMemoryDataSourceImpl @Inject constructor() : ConfigurationMemoryDataSource {

    private var configuration: ConfigurationApiJson? = null

    override fun setConfiguration(configuration: ConfigurationApiJson) {
        this.configuration = configuration
    }

    override suspend fun getConfiguration(): Result<ConfigurationApiJson> {
        return runCatching {
            configuration ?: throw NotCachedException("configuration not cached")
        }
    }
}
