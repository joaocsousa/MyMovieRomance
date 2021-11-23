package uk.co.twohundredapps.configuration.data.network

import kotlinx.coroutines.withContext
import uk.co.twohundredapps.api.NotCachedException
import uk.co.twohundredapps.configuration.data.network.models.`in`.Configuration
import uk.co.twohundredapps.coroutines.CoroutineContextProvider

interface ConfigurationRepository {
    suspend fun getConfiguration(): Result<Configuration>
}

internal class ConfigurationRepositoryImpl(
    private val coroutineContextProvider: CoroutineContextProvider,
    private val configurationMemoryDataSource: ConfigurationMemoryDataSource,
    private val configurationApi: ConfigurationApi,
) : ConfigurationRepository {
    override suspend fun getConfiguration(): Result<Configuration> {
        return withContext(coroutineContextProvider.io) {
            configurationMemoryDataSource.getConfiguration()
                .recoverCatching { error ->
                    when (error) {
                        is NotCachedException -> configurationApi.getConfiguration().onSuccess { configuration ->
                            configurationMemoryDataSource.setConfiguration(configuration)
                        }.getOrThrow()
                        else -> throw error
                    }
                }
        }
    }
}
