package uk.co.twohundredapps.logger.di

import org.koin.core.module.Module
import org.koin.dsl.module
import uk.co.twohundredapps.logger.DefaultLogger
import uk.co.twohundredapps.logger.Logger

val loggerDiModule: List<Module> = listOf(
    module {
        single<Logger> { DefaultLogger() }
    }
)
