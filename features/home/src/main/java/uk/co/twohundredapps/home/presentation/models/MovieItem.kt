package uk.co.twohundredapps.home.presentation.models

import arrow.core.Option

internal data class MovieItem(
    val title: String,
    val url: Option<String>,
)
