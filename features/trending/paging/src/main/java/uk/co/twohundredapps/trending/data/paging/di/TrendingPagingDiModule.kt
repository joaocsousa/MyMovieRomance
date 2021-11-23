package uk.co.twohundredapps.trending.data.paging.di

import org.koin.dsl.module
import uk.co.twohundredapps.trending.data.paging.TrendingApiPagingDataSourceFactory
import uk.co.twohundredapps.trending.data.paging.TrendingApiPagingDataSourceFactoryImpl
import uk.co.twohundredapps.trending.data.paging.TrendingPagingDataSource
import uk.co.twohundredapps.trending.data.paging.TrendingPagingDataSourceImpl

val trendingPagingDiModule = module {
    factory<TrendingApiPagingDataSourceFactory> {
        TrendingApiPagingDataSourceFactoryImpl(
            trendingApi = get()
        )
    }
    factory<TrendingPagingDataSource> {
        TrendingPagingDataSourceImpl(
            trendingApiPagingDataSourceFactory = get()
        )
    }
}
