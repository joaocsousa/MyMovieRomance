package uk.co.twohundredapps.home.presentation.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import uk.co.twohundredapps.home.presentation.mappers.MoviesUiMapper
import uk.co.twohundredapps.home.presentation.mappers.MoviesUiMapperImpl
import uk.co.twohundredapps.home.presentation.viewmodels.HomeViewModel
import uk.co.twohundredapps.home.presentation.viewmodels.HomeViewModelImpl

val homeDiModule = module {
    viewModel<HomeViewModel> {
        HomeViewModelImpl(
            coroutineContextProvider = get(),
            logger = get(),
            getDailyTrendingMovies = get(),
            moviesUiMapper = get()
        )
    }
    factory<MoviesUiMapper> {
        MoviesUiMapperImpl(coroutineContextProvider = get())
    }
}