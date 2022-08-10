package uk.co.twohundredapps.configuration.mappers

import uk.co.twohundredapps.configuration.data.network.models.`in`.ConfigurationApiJson
import uk.co.twohundredapps.configuration.models.ConfigurationModel
import uk.co.twohundredapps.domain.mappers.Mapper
import javax.inject.Inject

internal interface ConfigurationApiModelMapper : Mapper<ConfigurationApiJson, ConfigurationModel>

internal class ConfigurationApiModelMapperImpl @Inject constructor() : ConfigurationApiModelMapper {
    override suspend fun invoke(input: ConfigurationApiJson): ConfigurationModel {
        return ConfigurationModel(
            baseImageUrl = input.imagesConfiguration.secureBaseUrl,
            backdropSizes = input.imagesConfiguration.backdropSizes,
            logoSizes = input.imagesConfiguration.logoSizes,
            posterSizes = input.imagesConfiguration.posterSizes,
            profileSizes = input.imagesConfiguration.profileSizes,
            stillSizes = input.imagesConfiguration.stillSizes
        )
    }
}
