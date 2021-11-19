package uk.co.twohundredapps.trending.data.mappers

import uk.co.twohundredapps.coroutines.CoroutineContextProvider
import uk.co.twohundredapps.domain.mappers.PaginatedMapper
import uk.co.twohundredapps.trending.data.network.models.`in`.TrendingResult
import uk.co.twohundredapps.trending.domain.models.TrendingMovie

internal class TrendingPaginatedMovieMapper(
    coroutineContextProvider: CoroutineContextProvider,
    itemMapper: TrendingResultToTrendingMovieMapper
) : PaginatedMapper<TrendingResult, TrendingMovie>(coroutineContextProvider, itemMapper)