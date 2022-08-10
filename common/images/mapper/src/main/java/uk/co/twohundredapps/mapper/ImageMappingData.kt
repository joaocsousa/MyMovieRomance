package uk.co.twohundredapps.mapper

import uk.co.twohundredapps.configuration.models.ConfigurationModel

data class ImageMappingData(
    val configuration: ConfigurationModel,
    val imageType: ImageType,
    val imagePath: String?,
)
