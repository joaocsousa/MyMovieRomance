package uk.co.twohundredapps.strictmode.di

import org.koin.dsl.module
import uk.co.twohundredapps.strictmode.StrictModeInitializer
import uk.co.twohundredapps.strictmode.StrictModeInitializerImpl

val strictModeDiModule = module {
    factory<StrictModeInitializer> { StrictModeInitializerImpl() }
}