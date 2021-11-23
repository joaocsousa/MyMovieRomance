package uk.co.twohundredapps.data.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Paginated<T>(
    @SerialName("page")
    val page: Int,
    @SerialName("total_pages")
    val totalPages: Int,
    @SerialName("total_results")
    val totalItems: Int,
    @SerialName("results")
    val results: List<T>,
)
