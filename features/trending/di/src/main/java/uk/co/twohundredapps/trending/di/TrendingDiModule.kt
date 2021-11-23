package uk.co.twohundredapps.trending.di

import org.koin.core.module.Module
import uk.co.twohundredapps.trending.data.di.trendingDataDiModule
import uk.co.twohundredapps.trending.data.network.di.trendingNetworkDiModule
import uk.co.twohundredapps.trending.data.paging.di.trendingPagingDiModule
import uk.co.twohundredapps.trending.domain.di.trendingDomainDiModule

val trendingDiModule: List<Module> = listOf(
    trendingDataDiModule,
    trendingNetworkDiModule,
    trendingPagingDiModule,
    trendingDomainDiModule
)
