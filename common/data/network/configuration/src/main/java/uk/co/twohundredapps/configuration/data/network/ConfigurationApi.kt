package uk.co.twohundredapps.configuration.data.network

import uk.co.twohundredapps.trending.data.network.models.`in`.Configuration

interface ConfigurationApi {
    suspend fun getConfiguration(): Result<Configuration>
}
