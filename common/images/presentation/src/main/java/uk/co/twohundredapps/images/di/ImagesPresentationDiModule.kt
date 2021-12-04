package uk.co.twohundredapps.images.di

import org.koin.dsl.module
import uk.co.twohundredapps.images.ImageSelector
import uk.co.twohundredapps.images.ImageSelectorImpl

val imagesPresentationDiModule = module {
    single<ImageSelector> {
        ImageSelectorImpl()
    }
}
