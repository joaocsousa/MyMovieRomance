package uk.co.twohundredapps.trending.domain.di

import org.koin.dsl.module
import uk.co.twohundredapps.trending.domain.usecases.GetDailyTrendingMovies
import uk.co.twohundredapps.trending.domain.usecases.GetDailyTrendingMoviesImpl

val trendingDomainDiModule = module {
    factory<GetDailyTrendingMovies> {
        GetDailyTrendingMoviesImpl(
            trendingRepository = get()
        )
    }
}
