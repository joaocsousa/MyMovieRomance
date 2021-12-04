package uk.co.twohundredapps.mymovieromance.di

import org.koin.core.module.Module
import uk.co.twohundredapps.configuration.di.configurationDiModule
import uk.co.twohundredapps.couroutines.di.coroutinesDiModule
import uk.co.twohundredapps.data.network.di.networkCoreDiModule
import uk.co.twohundredapps.home.presentation.di.homeDiModule
import uk.co.twohundredapps.images.di.imagesPresentationDiModule
import uk.co.twohundredapps.logger.di.loggerDiModule
import uk.co.twohundredapps.mapper.di.imagesMapperDiModule
import uk.co.twohundredapps.mymovieromance.infrastructure.config.di.configDiModule
import uk.co.twohundredapps.strictmode.di.strictModeDiModule
import uk.co.twohundredapps.trending.di.trendingDiModule

val allDiModules: List<Module> = configDiModule +
        loggerDiModule +
        networkCoreDiModule +
        coroutinesDiModule +
        trendingDiModule +
        homeDiModule +
        configurationDiModule +
        imagesMapperDiModule +
        imagesPresentationDiModule +
        strictModeDiModule
