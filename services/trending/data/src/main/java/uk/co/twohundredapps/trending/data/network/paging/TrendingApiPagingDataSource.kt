package uk.co.twohundredapps.trending.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import uk.co.twohundredapps.trending.data.network.api.TrendingApi
import uk.co.twohundredapps.trending.data.network.models.`in`.TrendingResult
import uk.co.twohundredapps.trending.data.network.models.out.MediaType
import uk.co.twohundredapps.trending.data.network.models.out.TimeWindow

internal abstract class TrendingApiPagingDataSource : PagingSource<Int, TrendingResult>() {
    abstract val mediaType: MediaType
    abstract val timeWindow: TimeWindow
}

internal class TrendingApiPagingDataSourceImpl(
    private val trendingApi: TrendingApi,
    override val mediaType: MediaType,
    override val timeWindow: TimeWindow,
) : TrendingApiPagingDataSource() {

    override fun getRefreshKey(state: PagingState<Int, TrendingResult>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TrendingResult> {
        val pageToLoad = params.key ?: 1
        return trendingApi.getTrending(mediaType = mediaType, timeWindow = timeWindow, page = pageToLoad).fold(
            onSuccess = { response ->
                LoadResult.Page(
                    data = response.results,
                    prevKey = if (response.page > 0) response.page - 1 else null,
                    nextKey = if (response.page < response.totalPages) response.page + 1 else null
                )
            },
            onFailure = { error ->
                LoadResult.Error(error)
            }
        )
    }
}
