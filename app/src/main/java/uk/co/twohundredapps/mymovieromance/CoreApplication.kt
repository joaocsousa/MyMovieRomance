package uk.co.twohundredapps.mymovieromance

import android.app.Application
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import uk.co.twohundredapps.logger.LoggerInitializer
import uk.co.twohundredapps.mymovieromance.di.allDiModules

class CoreApplication : Application() {

    private val logger by inject<LoggerInitializer>()

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CoreApplication)
            modules(allDiModules)
        }
        logger.init()
    }
}
