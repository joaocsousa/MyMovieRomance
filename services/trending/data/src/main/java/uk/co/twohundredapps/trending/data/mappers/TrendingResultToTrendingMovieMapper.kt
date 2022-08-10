package uk.co.twohundredapps.trending.data.mappers

import kotlinx.coroutines.withContext
import uk.co.twohundredapps.configuration.models.ConfigurationModel
import uk.co.twohundredapps.coroutines.CoroutineContextProvider
import uk.co.twohundredapps.domain.mappers.Mapper
import uk.co.twohundredapps.mapper.ImageMappingData
import uk.co.twohundredapps.mapper.ImageType
import uk.co.twohundredapps.mapper.ImageUrlMapper
import uk.co.twohundredapps.trending.data.network.models.`in`.TrendingResultApiJson
import uk.co.twohundredapps.trending.domain.models.TrendingMovie
import javax.inject.Inject

internal interface TrendingResultToTrendingMovieMapper : Mapper<Pair<ConfigurationModel, TrendingResultApiJson>, TrendingMovie>

internal class TrendingResultToTrendingMovieMapperImpl @Inject constructor(
    private val coroutineContextProvider: CoroutineContextProvider,
    private val imageUrlMapper: ImageUrlMapper,
) : TrendingResultToTrendingMovieMapper {
    override suspend fun invoke(input: Pair<ConfigurationModel, TrendingResultApiJson>): TrendingMovie {
        return withContext(coroutineContextProvider.default) {
            val trending = input.second
            val posters = imageUrlMapper(
                input = ImageMappingData(
                    configuration = input.first,
                    imageType = ImageType.Poster,
                    imagePath = trending.posterPath
                )
            ).getOrDefault(emptyList())
            TrendingMovie(name = trending.title, posters = posters)
        }
    }
}
