package uk.co.twohundredapps.mymovieromance.di

import org.koin.core.module.Module
import uk.co.twohundredapps.couroutines.di.coroutinesModule
import uk.co.twohundredapps.data.network.di.networkCoreModule
import uk.co.twohundredapps.logger.di.loggerDiModule
import uk.co.twohundredapps.mymovieromance.infrastructure.config.di.configModule
import uk.co.twohundredapps.trending.di.trendingModule

val allDiModules: List<Module> =
    configModule +
            loggerDiModule +
            networkCoreModule +
            coroutinesModule +
            trendingModule

