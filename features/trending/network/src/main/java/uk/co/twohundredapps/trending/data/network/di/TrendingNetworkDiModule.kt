package uk.co.twohundredapps.trending.data.network.di

import org.koin.dsl.module
import uk.co.twohundredapps.trending.data.network.TrendingApi
import uk.co.twohundredapps.trending.data.network.TrendingApiClient

val trendingNetworkDiModule = module {
    factory<TrendingApi> {
        TrendingApiClient(
            coreApiClient = get()
        )
    }
}
