package uk.co.twohundredapps.trending.domain.usecases

import uk.co.twohundredapps.domain.models.Paginated
import uk.co.twohundredapps.domain.usecases.UseCase
import uk.co.twohundredapps.trending.domain.models.TrendingMovie
import uk.co.twohundredapps.trending.domain.repositories.TrendingRepository

interface GetDailyTrendingMovies : UseCase.Suspending<Result<Paginated<TrendingMovie>>>

internal class GetDailyTrendingMoviesImpl(
    private val trendingRepository: TrendingRepository
) : GetDailyTrendingMovies {

    override suspend fun invoke(): Result<Paginated<TrendingMovie>> {
        return trendingRepository.getDailyTrendingMovies()
    }
}
