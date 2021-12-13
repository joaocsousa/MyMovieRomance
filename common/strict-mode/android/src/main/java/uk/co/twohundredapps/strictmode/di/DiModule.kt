package uk.co.twohundredapps.strictmode.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uk.co.twohundredapps.strictmode.StrictModeInitializer
import uk.co.twohundredapps.strictmode.StrictModeInitializerImpl

@Module
@InstallIn(SingletonComponent::class)
internal interface DiModule {
    @Binds
    fun StrictModeInitializerImpl.bindLoggerInitializer(): StrictModeInitializer
}
