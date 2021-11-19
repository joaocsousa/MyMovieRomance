package uk.co.twohundredapps.configuration.data.network

import uk.co.twohundredapps.data.network.CoreApiClient
import uk.co.twohundredapps.trending.data.network.models.`in`.Configuration

internal class ConfigurationApiClient(
    private val coreApiClient: CoreApiClient,
) : ConfigurationApi {
    override suspend fun getConfiguration(): Result<Configuration> {
        return runCatching {
            coreApiClient.get("configuration")
        }
    }
}