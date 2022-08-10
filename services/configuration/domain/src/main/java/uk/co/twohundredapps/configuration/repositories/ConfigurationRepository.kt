package uk.co.twohundredapps.configuration.repositories

import uk.co.twohundredapps.configuration.models.ConfigurationModel

interface ConfigurationRepository {
    suspend fun getConfiguration(): Result<ConfigurationModel>
}
