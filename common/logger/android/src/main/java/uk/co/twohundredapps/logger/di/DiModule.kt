package uk.co.twohundredapps.logger.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uk.co.twohundredapps.logger.AndroidLogHandler
import uk.co.twohundredapps.logger.AndroidLoggerInitializer
import uk.co.twohundrerapps.logger.LoggerInitializer
import java.util.logging.Handler

@Module
@InstallIn(SingletonComponent::class)
internal interface DiModule {

    @Binds
    fun AndroidLoggerInitializer.bindLoggerInitializer(): LoggerInitializer

    @Binds
    fun AndroidLogHandler.bindLogger(): Handler
}