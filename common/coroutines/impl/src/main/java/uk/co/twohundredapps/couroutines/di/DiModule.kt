package uk.co.twohundredapps.couroutines.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uk.co.twohundredapps.coroutines.CoroutineContextProvider
import uk.co.twohundredapps.couroutines.DefaultCoroutineContextProvider

@Module
@InstallIn(SingletonComponent::class)
internal interface DiModule {
    @Binds
    fun DefaultCoroutineContextProvider.bindLoggerInitializer(): CoroutineContextProvider
}
