package uk.co.twohundredapps.configuration.di

import org.koin.dsl.module
import uk.co.twohundredapps.configuration.data.network.ConfigurationApi
import uk.co.twohundredapps.configuration.data.network.ConfigurationApiClient
import uk.co.twohundredapps.configuration.data.network.ConfigurationMemoryDataSource
import uk.co.twohundredapps.configuration.data.network.ConfigurationMemoryDataSourceImpl
import uk.co.twohundredapps.configuration.mappers.ConfigurationApiModelMapper
import uk.co.twohundredapps.configuration.mappers.ConfigurationApiModelMapperImpl
import uk.co.twohundredapps.configuration.repositories.ConfigurationRepository
import uk.co.twohundredapps.configuration.repositories.ConfigurationRepositoryImpl

val configurationDiModule = module {
    factory<ConfigurationApi> {
        ConfigurationApiClient(coreApiClient = get())
    }
    single<ConfigurationMemoryDataSource> {
        ConfigurationMemoryDataSourceImpl()
    }
    factory<ConfigurationRepository> {
        ConfigurationRepositoryImpl(
            coroutineContextProvider = get(),
            configurationMemoryDataSource = get(),
            configurationApi = get(),
            configurationApiModelMapper = get()
        )
    }
    factory<ConfigurationApiModelMapper> {
        ConfigurationApiModelMapperImpl()
    }
}
