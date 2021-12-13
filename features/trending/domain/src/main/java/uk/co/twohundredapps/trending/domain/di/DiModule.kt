package uk.co.twohundredapps.trending.domain.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uk.co.twohundredapps.trending.domain.usecases.GetDailyTrendingMovies
import uk.co.twohundredapps.trending.domain.usecases.GetDailyTrendingMoviesImpl

@Module
@InstallIn(SingletonComponent::class)
internal interface DiModule {
    @Binds
    fun GetDailyTrendingMoviesImpl.bindGetDailyTrendingMovies(): GetDailyTrendingMovies
}
