package uk.co.twohundredapps.trending.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uk.co.twohundredapps.trending.data.mappers.TrendingResultToTrendingMovieMapper
import uk.co.twohundredapps.trending.data.mappers.TrendingResultToTrendingMovieMapperImpl
import uk.co.twohundredapps.trending.data.repositories.TrendingRepositoryImpl
import uk.co.twohundredapps.trending.domain.repositories.TrendingRepository

@Module
@InstallIn(SingletonComponent::class)
internal interface DiModule {
    @Binds
    fun TrendingRepositoryImpl.bindTrendingRepository(): TrendingRepository

    @Binds
    fun TrendingResultToTrendingMovieMapperImpl.bindTrendingResultToTrendingMovieMapper(): TrendingResultToTrendingMovieMapper
}
