package uk.co.twohundredapps.trending.domain.models

import arrow.core.Option

data class TrendingMovie(val name: String, val posterUrl: Option<String>)
