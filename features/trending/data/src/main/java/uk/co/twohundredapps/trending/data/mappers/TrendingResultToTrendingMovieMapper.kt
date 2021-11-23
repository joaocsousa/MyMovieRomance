package uk.co.twohundredapps.trending.data.mappers

import kotlinx.coroutines.withContext
import uk.co.twohundredapps.core.toOption
import uk.co.twohundredapps.coroutines.CoroutineContextProvider
import uk.co.twohundredapps.domain.mappers.Mapper
import uk.co.twohundredapps.images.data.ImageType
import uk.co.twohundredapps.images.data.ImageUrlData
import uk.co.twohundredapps.images.data.ImageUrlFormatter
import uk.co.twohundredapps.trending.data.network.models.`in`.TrendingResult
import uk.co.twohundredapps.trending.domain.models.TrendingMovie

internal interface TrendingResultToTrendingMovieMapper : Mapper<TrendingResult, TrendingMovie>

internal class TrendingResultToTrendingMovieMapperImpl(
    private val coroutineContextProvider: CoroutineContextProvider,
    private val imageUrlFormatter: ImageUrlFormatter,
) : TrendingResultToTrendingMovieMapper {
    override suspend fun invoke(input: TrendingResult): TrendingMovie {
        return withContext(coroutineContextProvider.default) {
            TrendingMovie(
                name = input.title,
                posterUrl = imageUrlFormatter(
                    input = ImageUrlData(
                        imageType = ImageType.Poster,
                        path = input.posterPath
                    )
                ).toOption()
            )
        }
    }
}
