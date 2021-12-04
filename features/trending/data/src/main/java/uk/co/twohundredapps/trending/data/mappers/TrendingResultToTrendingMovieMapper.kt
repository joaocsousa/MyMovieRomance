package uk.co.twohundredapps.trending.data.mappers

import kotlinx.coroutines.withContext
import uk.co.twohundredapps.configuration.models.Configuration
import uk.co.twohundredapps.coroutines.CoroutineContextProvider
import uk.co.twohundredapps.domain.mappers.Mapper
import uk.co.twohundredapps.mapper.ImageMappingData
import uk.co.twohundredapps.mapper.ImageType
import uk.co.twohundredapps.mapper.ImageUrlMapper
import uk.co.twohundredapps.trending.data.network.models.`in`.TrendingResult
import uk.co.twohundredapps.trending.domain.models.TrendingMovie

internal interface TrendingResultToTrendingMovieMapper : Mapper<Pair<Configuration, TrendingResult>, TrendingMovie>

internal class TrendingResultToTrendingMovieMapperImpl(
    private val coroutineContextProvider: CoroutineContextProvider,
    private val imageUrlMapper: ImageUrlMapper,
) : TrendingResultToTrendingMovieMapper {
    override suspend fun invoke(input: Pair<Configuration, TrendingResult>): TrendingMovie {
        return withContext(coroutineContextProvider.default) {
            val trending = input.second
            TrendingMovie(
                name = trending.title,
                posters = imageUrlMapper(
                    input = ImageMappingData(
                        configuration = input.first,
                        imageType = ImageType.Poster,
                        imagePath = trending.posterPath
                    )
                ).fold(onSuccess = { it }, onFailure = { emptyList() })
            )
        }
    }
}
