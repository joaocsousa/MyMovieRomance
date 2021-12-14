package uk.co.twohundredapps.trending.domain.repositories

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import uk.co.twohundredapps.trending.domain.models.TrendingMovie

interface TrendingRepository {
    fun getDailyTrendingMovies(): Flow<PagingData<TrendingMovie>>
}
