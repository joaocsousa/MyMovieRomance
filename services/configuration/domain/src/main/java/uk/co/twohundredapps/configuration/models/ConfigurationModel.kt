package uk.co.twohundredapps.configuration.models

data class ConfigurationModel(
    val baseImageUrl: String,
    val backdropSizes: List<String>,
    val logoSizes: List<String>,
    val posterSizes: List<String>,
    val profileSizes: List<String>,
    val stillSizes: List<String>,
)
