package uk.co.twohundredapps.home.presentation.mappers

import kotlinx.coroutines.withContext
import uk.co.twohundredapps.coroutines.CoroutineContextProvider
import uk.co.twohundredapps.domain.mappers.Mapper
import uk.co.twohundredapps.home.presentation.models.MovieItem
import uk.co.twohundredapps.trending.domain.models.TrendingMovie

internal interface MovieUiMapper : Mapper<TrendingMovie, MovieItem>

internal class MovieUiMapperImpl(
    private val coroutineContextProvider: CoroutineContextProvider,
) : MovieUiMapper {
    override suspend fun invoke(input: TrendingMovie): MovieItem {
        return withContext(coroutineContextProvider.default) {
            MovieItem(
                title = input.name,
                posters = input.posters
            )
        }
    }
}
