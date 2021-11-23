package uk.co.twohundredapps.images.data.di

import org.koin.dsl.module
import uk.co.twohundredapps.images.data.ImageUrlFormatter
import uk.co.twohundredapps.images.data.ImageUrlFormatterImpl

val imagesDiModule = module {
    factory<ImageUrlFormatter> {
        ImageUrlFormatterImpl(
            coroutineContextProvider = get(),
            configurationRepository = get()
        )
    }
}
