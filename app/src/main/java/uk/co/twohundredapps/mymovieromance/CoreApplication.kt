package uk.co.twohundredapps.mymovieromance

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import uk.co.twohundredapps.analytics.AnalyticsInitializer
import uk.co.twohundrerapps.logger.LoggerInitializer
import javax.inject.Inject

@HiltAndroidApp
class CoreApplication : Application() {

    @Inject
    lateinit var loggerInitializer: LoggerInitializer

    @Inject
    lateinit var analyticsInitializers: Set<@JvmSuppressWildcards AnalyticsInitializer>

    override fun onCreate() {
        super.onCreate()
        loggerInitializer.initialize()
        analyticsInitializers.forEach(AnalyticsInitializer::initialize)
    }
}
