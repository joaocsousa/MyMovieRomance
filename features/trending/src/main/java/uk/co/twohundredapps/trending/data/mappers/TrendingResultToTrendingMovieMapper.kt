package uk.co.twohundredapps.trending.data.mappers

import uk.co.twohundredapps.domain.mappers.Mapper
import uk.co.twohundredapps.trending.data.network.models.`in`.TrendingResult
import uk.co.twohundredapps.trending.domain.models.TrendingMovie

internal class TrendingResultToTrendingMovieMapper(
) : Mapper<TrendingResult, TrendingMovie> {
    override fun invoke(input: TrendingResult): TrendingMovie {
        return TrendingMovie(
            name = input.title,
            posterUrl = input.posterPath
        )
    }
}