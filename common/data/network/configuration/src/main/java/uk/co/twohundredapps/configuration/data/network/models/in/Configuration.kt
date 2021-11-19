package uk.co.twohundredapps.trending.data.network.models.`in`

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Configuration(
    @SerialName("images")
    val imagesConfiguration: ImagesConfiguration,
)
