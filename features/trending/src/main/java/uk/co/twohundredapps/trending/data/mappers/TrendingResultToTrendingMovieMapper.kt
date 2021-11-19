package uk.co.twohundredapps.trending.data.mappers

import kotlinx.coroutines.withContext
import uk.co.twohundredapps.coroutines.CoroutineContextProvider
import uk.co.twohundredapps.domain.mappers.Mapper
import uk.co.twohundredapps.trending.data.network.models.`in`.TrendingResult
import uk.co.twohundredapps.trending.domain.models.TrendingMovie

internal class TrendingResultToTrendingMovieMapper(
    private val coroutineContextProvider: CoroutineContextProvider
) : Mapper<TrendingResult, TrendingMovie> {
    override suspend fun invoke(input: TrendingResult): TrendingMovie {
        return withContext(coroutineContextProvider.default) {
            TrendingMovie(
                name = input.title,
                posterUrl = input.posterPath
            )
        }
    }
}