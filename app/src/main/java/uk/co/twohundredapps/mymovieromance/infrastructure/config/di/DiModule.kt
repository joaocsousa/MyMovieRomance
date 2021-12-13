package uk.co.twohundredapps.mymovieromance.infrastructure.config.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uk.co.twohundredapps.infrastructure.config.BaseApiUrlProvider
import uk.co.twohundredapps.infrastructure.config.BuildConfigProvider
import uk.co.twohundredapps.infrastructure.config.ContextDirectoryProvider
import uk.co.twohundredapps.mymovieromance.infrastructure.config.BaseApiUrlProviderImpl
import uk.co.twohundredapps.mymovieromance.infrastructure.config.BuildConfigProviderImpl
import uk.co.twohundredapps.mymovieromance.infrastructure.config.ContextDirectoryProviderImpl

@Module
@InstallIn(SingletonComponent::class)
internal interface DiModule {
    @Binds
    fun BuildConfigProviderImpl.bindBuildConfigProvider(): BuildConfigProvider

    @Binds
    fun BaseApiUrlProviderImpl.bindBaseApiUrlProvider(): BaseApiUrlProvider

    @Binds
    fun ContextDirectoryProviderImpl.bindContextDirectoryProvider(): ContextDirectoryProvider
}