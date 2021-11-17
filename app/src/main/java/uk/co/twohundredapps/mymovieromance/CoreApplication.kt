package uk.co.twohundredapps.mymovieromance

import android.app.Application
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import uk.co.twohundredapps.infrastructure.config.BuildConfigProvider
import uk.co.twohundredapps.logger.Logger
import uk.co.twohundredapps.mymovieromance.di.allDiModules

class CoreApplication : Application() {

    private val logger by inject<Logger>()
    private val buildConfigProvider by inject<BuildConfigProvider>()

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CoreApplication)
            modules(allDiModules)
        }
        if (buildConfigProvider.isDebug) {
            logger.init()
        }
    }
}
