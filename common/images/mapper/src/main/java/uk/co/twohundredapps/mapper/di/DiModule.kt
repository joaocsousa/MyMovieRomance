package uk.co.twohundredapps.mapper.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uk.co.twohundredapps.mapper.ImageUrlMapper
import uk.co.twohundredapps.mapper.ImageUrlMapperImpl

@Module
@InstallIn(SingletonComponent::class)
internal interface DiModule {
    @Binds
    fun ImageUrlMapperImpl.bindImageUrlMapper(): ImageUrlMapper
}
