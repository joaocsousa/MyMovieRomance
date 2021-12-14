package uk.co.twohundredapps.configuration.data.network

import uk.co.twohundredapps.configuration.data.network.models.`in`.Configuration

internal interface ConfigurationDataSource {
    suspend fun getConfiguration(): Result<Configuration>
}
