package uk.co.twohundredapps.trending.data.network

import uk.co.twohundredapps.data.network.models.Paginated
import uk.co.twohundredapps.trending.data.network.models.`in`.TrendingResult
import uk.co.twohundredapps.trending.data.network.models.out.MediaType
import uk.co.twohundredapps.trending.data.network.models.out.TimeWindow

internal interface TrendingApi {
    suspend fun getTrending(mediaType: MediaType, timeWindow: TimeWindow): Result<Paginated<TrendingResult>>
}
