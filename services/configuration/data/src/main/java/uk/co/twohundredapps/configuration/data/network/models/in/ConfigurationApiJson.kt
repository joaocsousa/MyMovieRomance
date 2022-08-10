package uk.co.twohundredapps.configuration.data.network.models.`in`

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigurationApiJson(
    @SerialName("images")
    val imagesConfiguration: ImagesConfigurationApiJson,
)
