package uk.co.twohundredapps.trending.domain.usecases

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import uk.co.twohundredapps.domain.usecases.UseCase
import uk.co.twohundredapps.trending.domain.models.TrendingMovie
import uk.co.twohundredapps.trending.domain.repositories.TrendingRepository

interface GetDailyTrendingMovies : UseCase.AsyncStream<PagingData<TrendingMovie>>

internal class GetDailyTrendingMoviesImpl(
    private val trendingRepository: TrendingRepository,
) : GetDailyTrendingMovies {

    override fun invoke(): Flow<PagingData<TrendingMovie>> {
        return trendingRepository.getDailyTrendingMovies()
    }
}
