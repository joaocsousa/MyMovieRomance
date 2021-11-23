package uk.co.twohundredapps.configuration.data.network.di

import org.koin.dsl.module
import uk.co.twohundredapps.configuration.data.network.*

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
            configurationApi = get()
        )
    }
}
