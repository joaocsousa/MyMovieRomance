package uk.co.twohundredapps.configuration.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uk.co.twohundredapps.configuration.data.network.ConfigurationApi
import uk.co.twohundredapps.configuration.data.network.ConfigurationApiClient
import uk.co.twohundredapps.configuration.data.network.ConfigurationMemoryDataSource
import uk.co.twohundredapps.configuration.data.network.ConfigurationMemoryDataSourceImpl
import uk.co.twohundredapps.configuration.mappers.ConfigurationApiModelMapper
import uk.co.twohundredapps.configuration.mappers.ConfigurationApiModelMapperImpl
import uk.co.twohundredapps.configuration.repositories.ConfigurationRepository
import uk.co.twohundredapps.configuration.repositories.ConfigurationRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
internal interface DiModule {

    @Binds
    fun ConfigurationApiClient.provideConfigurationApiClient(): ConfigurationApi

    @Binds
    fun ConfigurationMemoryDataSourceImpl.provideConfigurationMemoryDataSource(): ConfigurationMemoryDataSource

    @Binds
    fun ConfigurationRepositoryImpl.provideConfigurationRepository(): ConfigurationRepository

    @Binds
    fun ConfigurationApiModelMapperImpl.provideConfigurationApiModelMapper(): ConfigurationApiModelMapper
}
