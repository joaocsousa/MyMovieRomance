package uk.co.twohundredapps.trending.data.network.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uk.co.twohundredapps.trending.data.network.TrendingApi
import uk.co.twohundredapps.trending.data.network.TrendingApiClient

@Module
@InstallIn(SingletonComponent::class)
internal interface DiModule {
    @Binds
    fun TrendingApiClient.bindTrendingApi(): TrendingApi
}
