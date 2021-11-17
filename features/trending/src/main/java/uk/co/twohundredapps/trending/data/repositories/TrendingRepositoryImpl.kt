package uk.co.twohundredapps.trending.data.repositories

import kotlinx.coroutines.withContext
import uk.co.twohundredapps.coroutines.CoroutineContextProvider
import uk.co.twohundredapps.domain.models.Paginated
import uk.co.twohundredapps.trending.data.mappers.TrendingPaginatedMovieMapper
import uk.co.twohundredapps.trending.data.network.TrendingApi
import uk.co.twohundredapps.trending.data.network.models.out.MediaType
import uk.co.twohundredapps.trending.data.network.models.out.TimeWindow
import uk.co.twohundredapps.trending.domain.models.TrendingMovie
import uk.co.twohundredapps.trending.domain.repositories.TrendingRepository

internal class TrendingRepositoryImpl(
    private val coroutineContextProvider: CoroutineContextProvider,
    private val trendingApi: TrendingApi,
    private val trendingPaginatedMovieMapper: TrendingPaginatedMovieMapper
) : TrendingRepository {
    override suspend fun getDailyTrendingMovies(): Result<Paginated<TrendingMovie>> {
        return withContext(coroutineContextProvider.io) {
            trendingApi.getTrending(mediaType = MediaType.Movie, timeWindow = TimeWindow.Day)
                .map { results ->
                    trendingPaginatedMovieMapper(results)
                }
        }
    }
}