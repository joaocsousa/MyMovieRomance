package uk.co.twohundredapps.mymovieromance.infrastructure.config.di

import org.koin.core.module.Module
import org.koin.dsl.module
import uk.co.twohundredapps.infrastructure.config.BaseApiUrlProvider
import uk.co.twohundredapps.infrastructure.config.BuildConfigProvider
import uk.co.twohundredapps.mymovieromance.infrastructure.config.BaseApiUrlProviderImpl
import uk.co.twohundredapps.mymovieromance.infrastructure.config.BuildConfigProviderImpl

val configModule: List<Module> = listOf(
    module {
        factory<BuildConfigProvider> {
            BuildConfigProviderImpl()
        }
        factory<BaseApiUrlProvider> {
            BaseApiUrlProviderImpl()
        }
    }
)
