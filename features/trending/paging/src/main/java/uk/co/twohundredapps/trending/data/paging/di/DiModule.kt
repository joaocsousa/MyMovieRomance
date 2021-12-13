package uk.co.twohundredapps.trending.data.paging.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uk.co.twohundredapps.trending.data.paging.TrendingApiPagingDataSourceFactory
import uk.co.twohundredapps.trending.data.paging.TrendingApiPagingDataSourceFactoryImpl
import uk.co.twohundredapps.trending.data.paging.TrendingPagingDataSource
import uk.co.twohundredapps.trending.data.paging.TrendingPagingDataSourceImpl

@Module
@InstallIn(SingletonComponent::class)
internal interface DiModule {
    @Binds
    fun TrendingApiPagingDataSourceFactoryImpl.bindTrendingApiPagingDataSourceFactory(): TrendingApiPagingDataSourceFactory

    @Binds
    fun TrendingPagingDataSourceImpl.bindTrendingPagingDataSource(): TrendingPagingDataSource
}
