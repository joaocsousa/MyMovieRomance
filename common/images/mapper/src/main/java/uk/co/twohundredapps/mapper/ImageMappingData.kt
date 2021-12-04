package uk.co.twohundredapps.mapper

import uk.co.twohundredapps.configuration.models.Configuration

data class ImageMappingData(
    val configuration: Configuration,
    val imageType: ImageType,
    val imagePath: String?,
)
