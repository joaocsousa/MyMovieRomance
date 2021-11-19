package uk.co.twohundredapps.couroutines.di

import org.koin.dsl.module
import uk.co.twohundredapps.coroutines.CoroutineContextProvider
import uk.co.twohundredapps.couroutines.DefaultCoroutineContextProvider

val coroutinesDiModule = listOf(
    module {
        factory<CoroutineContextProvider> {
            DefaultCoroutineContextProvider()
        }
    }
)