package uk.co.twohundredapps.home.presentation.mappers

import kotlinx.coroutines.withContext
import uk.co.twohundredapps.coroutines.CoroutineContextProvider
import uk.co.twohundredapps.domain.mappers.Mapper
import uk.co.twohundredapps.domain.models.Paginated
import uk.co.twohundredapps.home.presentation.models.MovieItem
import uk.co.twohundredapps.trending.domain.models.TrendingMovie

internal interface MoviesUiMapper : Mapper<Paginated<TrendingMovie>, List<MovieItem>>

internal class MoviesUiMapperImpl(
    private val coroutineContextProvider: CoroutineContextProvider
) : MoviesUiMapper {
    override suspend fun invoke(input: Paginated<TrendingMovie>): List<MovieItem> {
        return withContext(coroutineContextProvider.default) {
            input.results.map { trending ->
                MovieItem(
                    title = trending.name,
                    url = trending.posterUrl
                )
            }
        }
    }
}