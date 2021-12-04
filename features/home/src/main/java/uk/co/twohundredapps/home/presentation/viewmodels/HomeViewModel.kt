package uk.co.twohundredapps.home.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import uk.co.twohundredapps.home.presentation.mappers.MovieUiMapper
import uk.co.twohundredapps.home.presentation.models.MovieItem
import uk.co.twohundredapps.logger.logy
import uk.co.twohundredapps.trending.domain.usecases.GetDailyTrendingMovies

internal class HomeViewModelImpl(
    getDailyTrendingMovies: GetDailyTrendingMovies,
    private val movieUiMapper: MovieUiMapper,
) : HomeViewModel() {

    override fun onMovieSelected(movie: MovieItem) {
        logy.d("Selected $movie")
    }

    override val state: Flow<PagingData<MovieItem>> = getDailyTrendingMovies().cachedIn(viewModelScope).map { pagingData ->
        pagingData.map { trending ->
            movieUiMapper(trending)
        }
    }
}

internal abstract class HomeViewModel : ViewModel() {
    abstract fun onMovieSelected(movie: MovieItem)
    abstract val state: Flow<PagingData<MovieItem>>
}
