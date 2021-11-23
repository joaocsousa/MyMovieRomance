package uk.co.twohundredapps.configuration.data.network

import uk.co.twohundredapps.configuration.data.network.models.`in`.Configuration
import uk.co.twohundredapps.data.network.CoreApiClient

internal class ConfigurationApiClient(
    private val coreApiClient: CoreApiClient,
) : ConfigurationApi {
    override suspend fun getConfiguration(): Result<Configuration> {
        return runCatching {
            coreApiClient.get("configuration")
        }
    }
}
