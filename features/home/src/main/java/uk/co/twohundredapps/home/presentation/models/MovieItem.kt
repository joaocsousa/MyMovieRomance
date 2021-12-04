package uk.co.twohundredapps.home.presentation.models

import uk.co.twohundredapps.images.Image

internal data class MovieItem(
    val title: String,
    val posters: List<Image>,
)
