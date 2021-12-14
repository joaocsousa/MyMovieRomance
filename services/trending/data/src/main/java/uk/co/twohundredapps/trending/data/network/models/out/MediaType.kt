package uk.co.twohundredapps.trending.data.network.models.out

sealed class MediaType(val name: String) {
    object Movie : MediaType("movie")
}
