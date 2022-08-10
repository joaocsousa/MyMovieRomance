package uk.co.twohundredapps.configuration.repositories

import kotlinx.coroutines.withContext
import uk.co.twohundredapps.api.NotCachedException
import uk.co.twohundredapps.configuration.data.network.ConfigurationApi
import uk.co.twohundredapps.configuration.data.network.ConfigurationMemoryDataSource
import uk.co.twohundredapps.configuration.mappers.ConfigurationApiModelMapper
import uk.co.twohundredapps.configuration.models.ConfigurationModel
import uk.co.twohundredapps.coroutines.CoroutineContextProvider
import javax.inject.Inject

internal class ConfigurationRepositoryImpl @Inject constructor(
    private val coroutineContextProvider: CoroutineContextProvider,
    private val configurationMemoryDataSource: ConfigurationMemoryDataSource,
    private val configurationApi: ConfigurationApi,
    private val configurationApiModelMapper: ConfigurationApiModelMapper,
) : ConfigurationRepository {
    override suspend fun getConfiguration(): Result<ConfigurationModel> {
        return withContext(coroutineContextProvider.io) {
            configurationMemoryDataSource.getConfiguration()
                .recoverCatching { error ->
                    when (error) {
                        is NotCachedException -> configurationApi.getConfiguration()
                            .onSuccess(configurationMemoryDataSource::setConfiguration)
                            .getOrThrow()
                        else -> throw error
                    }
                }
                .map { configurationApiModelMapper(it) }
        }
    }
}
