package uk.co.twohundredapps.coroutines.di

import org.koin.dsl.module
import uk.co.twohundredapps.coroutines.CoroutineContextProvider
import uk.co.twohundredapps.coroutines.DefaultCoroutineContextProvider

val coroutinesModule = module {
    factory<CoroutineContextProvider> {
        DefaultCoroutineContextProvider()
    }
}