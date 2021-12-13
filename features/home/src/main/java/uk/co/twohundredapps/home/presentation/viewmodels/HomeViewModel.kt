package uk.co.twohundredapps.home.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import uk.co.twohundredapps.home.presentation.mappers.MovieUiMapper
import uk.co.twohundredapps.home.presentation.models.MovieItem
import uk.co.twohundredapps.logger.coreLogger
import uk.co.twohundredapps.trending.domain.usecases.GetDailyTrendingMovies
import javax.inject.Inject

@HiltViewModel
internal class HomeViewModel @Inject constructor(
    getDailyTrendingMovies: GetDailyTrendingMovies,
    private val movieUiMapper: MovieUiMapper,
) : ViewModel() {

    fun onMovieSelected(movie: MovieItem) {
        coreLogger.d("Selected $movie")
    }

    val state: Flow<PagingData<MovieItem>> = getDailyTrendingMovies().cachedIn(viewModelScope).map { pagingData ->
        pagingData.map { trending ->
            movieUiMapper(trending)
        }
    }
}
