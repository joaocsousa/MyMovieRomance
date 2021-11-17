package uk.co.twohundredapps.data.network.di

import org.koin.core.module.Module
import org.koin.dsl.module
import uk.co.twohundredapps.data.network.CoreApiClient
import uk.co.twohundredapps.data.network.HttpClientFactory
import uk.co.twohundredapps.data.network.HttpClientFactoryImpl

val networkCoreModule: List<Module> = listOf(
    module {
        factory<HttpClientFactory> {
            HttpClientFactoryImpl(
                buildConfigProvider = get(),
                localLogger = get()
            )
        }
        single {
            get<HttpClientFactory>().newInstance()
        }
        factory {
            CoreApiClient(
                httpClient = get(),
                baseApiUrlProvider = get()
            )
        }
    }
)
