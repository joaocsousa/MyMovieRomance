package uk.co.twohundredapps.trending.data.network.api

import uk.co.twohundredapps.data.network.CoreApiClient
import uk.co.twohundredapps.data.network.models.PaginatedApiJson
import uk.co.twohundredapps.trending.data.network.models.`in`.TrendingResultApiJson
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
    ): Result<PaginatedApiJson<TrendingResultApiJson>> {
        return runCatching {
            coreApiClient.get(
                path = "trending/${mediaType.name}/${timeWindow.name}",
                params = mapOf("page" to page)
            )
        }
    }
}
