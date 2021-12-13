package uk.co.twohundredapps.mymovieromance

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import uk.co.twohundrerapps.logger.LoggerInitializer
import javax.inject.Inject

@HiltAndroidApp
class CoreApplication : Application() {

    @Inject
    internal lateinit var loggerInitializer: LoggerInitializer

    override fun onCreate() {
        super.onCreate()
        loggerInitializer.initialize()
    }
}
