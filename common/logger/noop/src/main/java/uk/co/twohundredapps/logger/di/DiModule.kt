package uk.co.twohundredapps.logger.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uk.co.twohundredapps.logger.NoOpInitializer
import uk.co.twohundrerapps.logger.LoggerInitializer

@Module
@InstallIn(SingletonComponent::class)
internal interface DiModule {
    @Binds
    fun NoOpInitializer.bindLogger(): LoggerInitializer
}
