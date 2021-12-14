package uk.co.twohundredapps.trending.data.paging

import uk.co.twohundredapps.trending.data.network.api.TrendingApi
import uk.co.twohundredapps.trending.data.network.models.out.MediaType
import uk.co.twohundredapps.trending.data.network.models.out.TimeWindow
import javax.inject.Inject

internal fun interface TrendingApiPagingDataSourceFactory {
    operator fun invoke(mediaType: MediaType, timeWindow: TimeWindow): TrendingApiPagingDataSource
}

internal class TrendingApiPagingDataSourceFactoryImpl @Inject constructor(
    private val trendingApi: TrendingApi,
) : TrendingApiPagingDataSourceFactory {
    override fun invoke(mediaType: MediaType, timeWindow: TimeWindow): TrendingApiPagingDataSource {
        return TrendingApiPagingDataSourceImpl(
            trendingApi = trendingApi,
            mediaType = mediaType,
            timeWindow = timeWindow
        )
    }
}
