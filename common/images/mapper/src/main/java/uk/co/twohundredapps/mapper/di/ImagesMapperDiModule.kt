package uk.co.twohundredapps.mapper.di

import org.koin.dsl.module
import uk.co.twohundredapps.mapper.ImageUrlMapper
import uk.co.twohundredapps.mapper.ImageUrlMapperImpl

val imagesMapperDiModule = module {
    factory<ImageUrlMapper> {
        ImageUrlMapperImpl(coroutineContextProvider = get())
    }
}
