package uk.co.twohundredapps.configuration.data.network.di

import org.koin.dsl.module
import uk.co.twohundredapps.configuration.data.network.ConfigurationApi
import uk.co.twohundredapps.configuration.data.network.ConfigurationApiClient

val configurationApiModule = module {
    factory<ConfigurationApi> {
        ConfigurationApiClient(coreApiClient = get())
    }
}