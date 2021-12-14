package uk.co.twohundredapps.navigation

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface DiModule {
    @Binds
    fun NavigatorImpl.bindNavigatorImpl(): Navigator
}
