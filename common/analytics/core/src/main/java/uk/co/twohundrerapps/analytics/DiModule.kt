package uk.co.twohundrerapps.analytics

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uk.co.twohundredapps.analytics.AnalyticsEmitterFactory
import uk.co.twohundredapps.analytics.AnalyticsObserverFactory

@Module
@InstallIn(SingletonComponent::class)
internal interface DiModule {
    @Binds
    fun AnalyticsBridgeProviderImpl.bindAnalyticsEmitterFactory(): AnalyticsEmitterFactory

    @Binds
    fun AnalyticsBridgeProviderImpl.bindAnalyticsObserverFactory(): AnalyticsObserverFactory
}
