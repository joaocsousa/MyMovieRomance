package uk.co.twohundredapps.logger.di

import org.koin.core.module.Module
import org.koin.dsl.module
import uk.co.twohundredapps.logger.Logger
import uk.co.twohundredapps.logger.LoggerInitializer
import uk.co.twohundredapps.logger.NoopLogger

val loggerDiModule: List<Module> = listOf(
    module {
        factory { NoopLogger() }
        factory<Logger> { get<NoopLogger>() }
        factory<LoggerInitializer> { get<NoopLogger>() }
    }
)
