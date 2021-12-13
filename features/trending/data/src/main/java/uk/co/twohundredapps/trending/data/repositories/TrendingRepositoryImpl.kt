package uk.co.twohundredapps.trending.data.repositories

import androidx.paging.PagingData
import androidx.paging.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import uk.co.twohundredapps.configuration.repositories.ConfigurationRepository
import uk.co.twohundredapps.trending.data.mappers.TrendingResultToTrendingMovieMapper
import uk.co.twohundredapps.trending.data.network.models.out.MediaType
import uk.co.twohundredapps.trending.data.network.models.out.TimeWindow
import uk.co.twohundredapps.trending.data.paging.TrendingPagingDataSource
import uk.co.twohundredapps.trending.domain.models.TrendingMovie
import uk.co.twohundredapps.trending.domain.repositories.TrendingRepository
import javax.inject.Inject

internal class TrendingRepositoryImpl @Inject constructor(
    private val trendingPagingDataSource: TrendingPagingDataSource,
    private val trendingResultToTrendingMovieMapper: TrendingResultToTrendingMovieMapper,
    private val configurationRepository: ConfigurationRepository,
) : TrendingRepository {
    override fun getDailyTrendingMovies(): Flow<PagingData<TrendingMovie>> {
        val configurationFlow = flow {
            emit(configurationRepository.getConfiguration())
        }
        val trendingFlow = trendingPagingDataSource(
            mediaType = MediaType.Movie,
            timeWindow = TimeWindow.Day
        )
        return configurationFlow.combine(trendingFlow) { configurationResult, trendingResult ->
            configurationResult.fold(
                onSuccess = { configuration ->
                    trendingResult.map { trending ->
                        trendingResultToTrendingMovieMapper(configuration to trending)
                    }
                },
                onFailure = { throw it }
            )
        }
    }
}
