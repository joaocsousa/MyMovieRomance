package uk.co.twohundredapps.trending.data.network

import uk.co.twohundredapps.data.network.CoreApiClient
import uk.co.twohundredapps.data.network.models.Paginated
import uk.co.twohundredapps.trending.data.network.models.`in`.TrendingResult
import uk.co.twohundredapps.trending.data.network.models.out.MediaType
import uk.co.twohundredapps.trending.data.network.models.out.TimeWindow
import javax.inject.Inject

internal class TrendingApiClient @Inject constructor(
    private val coreApiClient: CoreApiClient,
) : TrendingApi {

    override suspend fun getTrending(
        mediaType: MediaType,
        timeWindow: TimeWindow,
        page: Int,
    ): Result<Paginated<TrendingResult>> {
        return runCatching {
            coreApiClient.get(
                path = "trending/${mediaType.name}/${timeWindow.name}",
                params = mapOf("page" to page)
            )
        }
    }
}
