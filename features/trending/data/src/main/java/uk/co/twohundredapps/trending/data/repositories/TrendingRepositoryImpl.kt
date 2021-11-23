package uk.co.twohundredapps.trending.data.repositories

import androidx.paging.PagingData
import androidx.paging.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import uk.co.twohundredapps.trending.data.mappers.TrendingResultToTrendingMovieMapper
import uk.co.twohundredapps.trending.data.network.models.out.MediaType
import uk.co.twohundredapps.trending.data.network.models.out.TimeWindow
import uk.co.twohundredapps.trending.data.paging.TrendingPagingDataSource
import uk.co.twohundredapps.trending.domain.models.TrendingMovie
import uk.co.twohundredapps.trending.domain.repositories.TrendingRepository

internal class TrendingRepositoryImpl(
    private val trendingPagingDataSource: TrendingPagingDataSource,
    private val trendingResultToTrendingMovieMapper: TrendingResultToTrendingMovieMapper,
) : TrendingRepository {
    override fun getDailyTrendingMovies(): Flow<PagingData<TrendingMovie>> {
        return trendingPagingDataSource(
            mediaType = MediaType.Movie,
            timeWindow = TimeWindow.Day
        ).map { data ->
            data.map { result ->
                trendingResultToTrendingMovieMapper(result)
            }
        }
    }
}
