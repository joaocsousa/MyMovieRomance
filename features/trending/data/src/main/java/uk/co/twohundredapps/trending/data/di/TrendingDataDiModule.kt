package uk.co.twohundredapps.trending.data.di

import org.koin.dsl.module
import uk.co.twohundredapps.trending.data.mappers.TrendingResultToTrendingMovieMapper
import uk.co.twohundredapps.trending.data.mappers.TrendingResultToTrendingMovieMapperImpl
import uk.co.twohundredapps.trending.data.repositories.TrendingRepositoryImpl
import uk.co.twohundredapps.trending.domain.repositories.TrendingRepository

val trendingDataDiModule = module {
    factory<TrendingRepository> {
        TrendingRepositoryImpl(
            trendingPagingDataSource = get(),
            trendingResultToTrendingMovieMapper = get()
        )
    }
    factory<TrendingResultToTrendingMovieMapper> {
        TrendingResultToTrendingMovieMapperImpl(
            coroutineContextProvider = get(),
            imageUrlFormatter = get()
        )
    }
}
