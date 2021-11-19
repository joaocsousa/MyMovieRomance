package uk.co.twohundredapps.home.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import uk.co.twohundredapps.coroutines.CoroutineContextProvider
import uk.co.twohundredapps.home.presentation.mappers.MoviesUiMapper
import uk.co.twohundredapps.home.presentation.models.HomeScreenState
import uk.co.twohundredapps.home.presentation.models.HomeScreenState.*
import uk.co.twohundredapps.home.presentation.models.MovieItem
import uk.co.twohundredapps.logger.Logger
import uk.co.twohundredapps.trending.domain.usecases.GetDailyTrendingMovies

internal class HomeViewModelImpl(
    coroutineContextProvider: CoroutineContextProvider,
    private val logger: Logger,
    private val getDailyTrendingMovies: GetDailyTrendingMovies,
    private val moviesUiMapper: MoviesUiMapper
) : HomeViewModel() {

    override fun onMovieSelected(movie: MovieItem) {
        logger.d("Selected $movie")
    }

    override val state = MutableStateFlow<HomeScreenState>(Init)

    init {
        viewModelScope.launch(coroutineContextProvider.main) {
            state.emit(Loading)
            getDailyTrendingMovies().fold(
                onSuccess = { movies ->
                    logger.d("Loaded $movies")
                    state.emit(Loaded(moviesUiMapper(movies)))
                },
                onFailure = {
                    logger.e(it)
                    state.emit(Error)
                }
            )
        }
    }
}

internal abstract class HomeViewModel : ViewModel() {
    abstract fun onMovieSelected(movie: MovieItem)
    abstract val state: StateFlow<HomeScreenState>
}