package uk.co.twohundredapps.trending.data.network.api

import uk.co.twohundredapps.data.network.models.PaginatedApiJson
import uk.co.twohundredapps.trending.data.network.models.`in`.TrendingResultApiJson
import uk.co.twohundredapps.trending.data.network.models.out.MediaType
import uk.co.twohundredapps.trending.data.network.models.out.TimeWindow

interface TrendingApi {
    suspend fun getTrending(mediaType: MediaType, timeWindow: TimeWindow, page: Int): Result<PaginatedApiJson<TrendingResultApiJson>>
}
