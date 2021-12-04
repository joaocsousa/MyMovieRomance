package uk.co.twohundredapps.configuration.repositories

import uk.co.twohundredapps.configuration.models.Configuration

interface ConfigurationRepository {
    suspend fun getConfiguration(): Result<Configuration>
}