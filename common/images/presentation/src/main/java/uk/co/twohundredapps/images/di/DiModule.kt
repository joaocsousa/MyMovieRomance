package uk.co.twohundredapps.images.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uk.co.twohundredapps.images.ImageSelector
import uk.co.twohundredapps.images.ImageSelectorImpl

@Module
@InstallIn(SingletonComponent::class)
internal interface DiModule {
    @Binds
    fun ImageSelectorImpl.bindLoggerInitializer(): ImageSelector
}