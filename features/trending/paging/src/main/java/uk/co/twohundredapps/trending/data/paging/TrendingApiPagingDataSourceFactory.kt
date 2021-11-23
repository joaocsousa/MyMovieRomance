package uk.co.twohundredapps.trending.data.paging

import uk.co.twohundredapps.trending.data.network.TrendingApi
import uk.co.twohundredapps.trending.data.network.models.out.MediaType
import uk.co.twohundredapps.trending.data.network.models.out.TimeWindow

internal fun interface TrendingApiPagingDataSourceFactory {
    operator fun invoke(mediaType: MediaType, timeWindow: TimeWindow): TrendingApiPagingDataSource
}

internal class TrendingApiPagingDataSourceFactoryImpl(
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
