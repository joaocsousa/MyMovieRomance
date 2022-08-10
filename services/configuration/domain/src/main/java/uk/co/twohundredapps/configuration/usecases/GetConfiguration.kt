package uk.co.twohundredapps.configuration.usecases

import uk.co.twohundredapps.configuration.models.ConfigurationModel
import uk.co.twohundredapps.configuration.repositories.ConfigurationRepository
import uk.co.twohundredapps.domain.usecases.UseCase

interface GetConfiguration : UseCase.Suspending<Result<ConfigurationModel>>

internal class GetConfigurationImpl(
    private val configurationRepository: ConfigurationRepository,
) : GetConfiguration {
    override suspend fun invoke(): Result<ConfigurationModel> {
        return configurationRepository.getConfiguration()
    }
}
