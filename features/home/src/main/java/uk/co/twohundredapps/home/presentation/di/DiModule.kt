package uk.co.twohundredapps.home.presentation.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uk.co.twohundredapps.home.presentation.mappers.MovieUiMapper
import uk.co.twohundredapps.home.presentation.mappers.MovieUiMapperImpl

@Module
@InstallIn(ViewModelComponent::class)
internal interface DiModule {
    @Binds
    fun MovieUiMapperImpl.bindMovieUiMapper(): MovieUiMapper
}
