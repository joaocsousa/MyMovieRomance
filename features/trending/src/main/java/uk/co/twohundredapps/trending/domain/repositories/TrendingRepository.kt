package uk.co.twohundredapps.trending.domain.repositories

import uk.co.twohundredapps.domain.models.Paginated
import uk.co.twohundredapps.trending.domain.models.TrendingMovie

internal interface TrendingRepository {
    suspend fun getDailyTrendingMovies(): Result<Paginated<TrendingMovie>>
}