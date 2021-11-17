package uk.co.twohundredapps.trending.di

import org.koin.dsl.module
import uk.co.twohundredapps.trending.data.mappers.TrendingPaginatedMovieMapper
import uk.co.twohundredapps.trending.data.mappers.TrendingResultToTrendingMovieMapper
import uk.co.twohundredapps.trending.data.network.TrendingApi
import uk.co.twohundredapps.trending.data.network.TrendingApiClient
import uk.co.twohundredapps.trending.data.repositories.TrendingRepositoryImpl
import uk.co.twohundredapps.trending.domain.repositories.TrendingRepository
import uk.co.twohundredapps.trending.domain.usecases.GetDailyTrendingMovies
import uk.co.twohundredapps.trending.domain.usecases.GetDailyTrendingMoviesImpl

val trendingModule = listOf(
    module {
        factory<GetDailyTrendingMovies> {
            GetDailyTrendingMoviesImpl(
                trendingRepository = get()
            )
        }
        factory<TrendingRepository> {
            TrendingRepositoryImpl(
                coroutineContextProvider = get(),
                trendingApi = get(),
                trendingPaginatedMovieMapper = get()
            )
        }
        factory<TrendingApi> {
            TrendingApiClient(coreApiClient = get())
        }
        factory {
            TrendingPaginatedMovieMapper(itemMapper = get())
        }
        factory {
            TrendingResultToTrendingMovieMapper()
        }
    }
)