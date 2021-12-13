package uk.co.twohundredapps.data.network.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import uk.co.twohundredapps.data.network.HttpClientFactory
import uk.co.twohundredapps.data.network.HttpClientFactoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DiModule {

    @Provides
    fun bindLoggerInitializer(httpClientFactoryImpl: HttpClientFactoryImpl): HttpClientFactory {
        return httpClientFactoryImpl
    }

    @Provides
    @Singleton
    fun provideAnalyticsService(httpClientFactory: HttpClientFactory): HttpClient {
        return httpClientFactory.newInstance()
    }
}