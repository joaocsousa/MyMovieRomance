package uk.co.twohundredapps.configuration.mappers

import uk.co.twohundredapps.configuration.data.network.models.`in`.Configuration
import uk.co.twohundredapps.domain.mappers.Mapper
import javax.inject.Inject
import uk.co.twohundredapps.configuration.models.Configuration as ConfigurationEntity

internal interface ConfigurationApiModelMapper : Mapper<Configuration, ConfigurationEntity>

internal class ConfigurationApiModelMapperImpl @Inject constructor() : ConfigurationApiModelMapper {
    override suspend fun invoke(input: Configuration): ConfigurationEntity {
        return ConfigurationEntity(
            baseImageUrl = input.imagesConfiguration.secureBaseUrl,
            backdropSizes = input.imagesConfiguration.backdropSizes,
            logoSizes = input.imagesConfiguration.logoSizes,
            posterSizes = input.imagesConfiguration.posterSizes,
            profileSizes = input.imagesConfiguration.profileSizes,
            stillSizes = input.imagesConfiguration.stillSizes
        )
    }
}
