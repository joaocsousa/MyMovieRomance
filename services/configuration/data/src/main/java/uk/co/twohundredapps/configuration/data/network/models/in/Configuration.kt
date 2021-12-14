package uk.co.twohundredapps.configuration.data.network.models.`in`

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Configuration(
    @SerialName("images")
    val imagesConfiguration: ImagesConfiguration,
)
