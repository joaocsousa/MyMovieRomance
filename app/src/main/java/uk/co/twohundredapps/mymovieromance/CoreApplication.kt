package uk.co.twohundredapps.mymovieromance

import android.app.Application
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import uk.co.twohundredapps.mymovieromance.di.allDiModules
import java.util.logging.Handler
import java.util.logging.Level
import java.util.logging.Logger

class CoreApplication : Application() {

    private val logHandler by inject<Handler>()

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CoreApplication)
            modules(allDiModules)
        }

        Logger.getLogger("").apply {
            level = Level.ALL
            handlers.forEach { removeHandler(it) }
            addHandler(logHandler)
        }
    }
}
