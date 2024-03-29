package uk.co.twohundredapps.configuration.data.network

import uk.co.twohundredapps.configuration.data.network.models.`in`.ConfigurationApiJson
import uk.co.twohundredapps.data.network.CoreApiClient
import javax.inject.Inject

internal interface ConfigurationApi : ConfigurationDataSource

internal class ConfigurationApiClient @Inject constructor(
    private val coreApiClient: CoreApiClient,
) : ConfigurationApi {
    override suspend fun getConfiguration(): Result<ConfigurationApiJson> {
        return runCatching {
            coreApiClient.get("configuration")
        }
    }
}
