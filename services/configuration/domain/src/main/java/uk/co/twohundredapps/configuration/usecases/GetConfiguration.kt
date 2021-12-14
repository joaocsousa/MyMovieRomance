package uk.co.twohundredapps.configuration.usecases

import uk.co.twohundredapps.configuration.models.Configuration
import uk.co.twohundredapps.configuration.repositories.ConfigurationRepository
import uk.co.twohundredapps.domain.usecases.UseCase

interface GetConfiguration : UseCase.Suspending<Result<Configuration>>

internal class GetConfigurationImpl(
    private val configurationRepository: ConfigurationRepository,
) : GetConfiguration {
    override suspend fun invoke(): Result<Configuration> {
        return configurationRepository.getConfiguration()
    }
}
