package uk.co.twohundredapps.trending.data.paging

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import uk.co.twohundredapps.trending.data.network.models.`in`.TrendingResult
import uk.co.twohundredapps.trending.data.network.models.out.MediaType
import uk.co.twohundredapps.trending.data.network.models.out.TimeWindow

interface TrendingPagingDataSource {
    operator fun invoke(mediaType: MediaType, timeWindow: TimeWindow): Flow<PagingData<TrendingResult>>
}

internal class TrendingPagingDataSourceImpl(
    private val trendingApiPagingDataSourceFactory: TrendingApiPagingDataSourceFactory,
) : TrendingPagingDataSource {
    override fun invoke(mediaType: MediaType, timeWindow: TimeWindow): Flow<PagingData<TrendingResult>> {
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
