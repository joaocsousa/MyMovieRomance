package uk.co.twohundredapps.home.presentation.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import uk.co.twohundredapps.home.presentation.mappers.MovieUiMapper
import uk.co.twohundredapps.home.presentation.mappers.MovieUiMapperImpl
import uk.co.twohundredapps.home.presentation.viewmodels.HomeViewModel
import uk.co.twohundredapps.home.presentation.viewmodels.HomeViewModelImpl

val homeDiModule = module {
    viewModel<HomeViewModel> {
        HomeViewModelImpl(
            getDailyTrendingMovies = get(),
            movieUiMapper = get()
        )
    }
    factory<MovieUiMapper> {
        MovieUiMapperImpl(coroutineContextProvider = get())
    }
}
