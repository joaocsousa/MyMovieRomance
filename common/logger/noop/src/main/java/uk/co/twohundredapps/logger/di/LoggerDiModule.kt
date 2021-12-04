package uk.co.twohundredapps.logger.di

import org.koin.core.module.Module
import org.koin.dsl.module
import uk.co.twohundredapps.logger.NoopLogger
import java.util.logging.Handler

val loggerDiModule: List<Module> = listOf(
    module {
        factory<Handler> { NoopLogger() }
    }
)
