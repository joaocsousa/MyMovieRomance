package com.example.listenerx

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import uk.co.twohundredapps.analytics.AnalyticsInitializer

@Module
@InstallIn(SingletonComponent::class)
internal interface DiModule {
    @Binds
    @IntoSet
    fun AnalyticsListenerX.bindAnalyticsListenerX(): AnalyticsInitializer
}
