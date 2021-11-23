package uk.co.twohundredapps.logger.di

import org.koin.core.module.Module
import org.koin.dsl.module
import uk.co.twohundredapps.logger.LoggerImpl
import uk.co.twohundredapps.logger.Logger
import uk.co.twohundredapps.logger.LoggerInitializer

val loggerDiModule: List<Module> = listOf(
    module {
        single { LoggerImpl() }
        single<Logger> { get<LoggerImpl>() }
        single<LoggerInitializer> { get<LoggerImpl>() }
    }
)
