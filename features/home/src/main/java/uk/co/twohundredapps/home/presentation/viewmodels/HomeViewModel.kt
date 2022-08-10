package uk.co.twohundredapps.home.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import uk.co.twohundredapps.analytics.AnalyticsEmitterFactory
import uk.co.twohundredapps.home.presentation.mappers.MovieUiMapper
import uk.co.twohundredapps.home.presentation.models.MovieItem
import uk.co.twohundredapps.logger.coreLogger
import uk.co.twohundredapps.trending.domain.usecases.GetDailyTrendingMovies
import uk.co.twohundrerapps.analytics.HomeEvent
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject internal constructor(
    getDailyTrendingMovies: GetDailyTrendingMovies,
    private val movieUiMapper: MovieUiMapper,
    private val analyticsEmitterFactory: AnalyticsEmitterFactory
) : ViewModel() {

    init {
        viewModelScope.launch {
            analyticsEmitterFactory.emitter(HomeEvent::class).emit(HomeEvent.Displayed(timestamp = System.currentTimeMillis()))
        }
    }

    fun onMovieSelected(movie: MovieItem) {
        coreLogger.d("Selected $movie")
    }

    val state: Flow<PagingData<MovieItem>> = getDailyTrendingMovies().cachedIn(viewModelScope).map { pagingData ->
        pagingData.map { trending ->
            movieUiMapper(trending)
        }
    }
}
