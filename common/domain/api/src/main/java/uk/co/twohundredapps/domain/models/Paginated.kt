package uk.co.twohundredapps.domain.models

data class Paginated<T>(
    val page: Int,
    val totalPages: Int,
    val results: List<T>
)
