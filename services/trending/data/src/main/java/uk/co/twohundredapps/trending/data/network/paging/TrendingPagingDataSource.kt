package uk.co.twohundredapps.trending.data.paging

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import uk.co.twohundredapps.trending.data.network.models.`in`.TrendingResultApiJson
import uk.co.twohundredapps.trending.data.network.models.out.MediaType
import uk.co.twohundredapps.trending.data.network.models.out.TimeWindow
import javax.inject.Inject

interface TrendingPagingDataSource {
    operator fun invoke(mediaType: MediaType, timeWindow: TimeWindow): Flow<PagingData<TrendingResultApiJson>>
}

internal class TrendingPagingDataSourceImpl @Inject constructor(
    private val trendingApiPagingDataSourceFactory: TrendingApiPagingDataSourceFactory,
) : TrendingPagingDataSource {
    override fun invoke(mediaType: MediaType, timeWindow: TimeWindow): Flow<PagingData<TrendingResultApiJson>> {
        return Pager(
            config = PagingConfig(pageSize = DEFAULT_PAGE_SIZE),
            pagingSourceFactory = {
                trendingApiPagingDataSourceFactory(
                    mediaType = mediaType,
                    timeWindow = timeWindow
                )
            }
        ).flow
    }

    private companion object {
        const val DEFAULT_PAGE_SIZE = 20
    }
}
