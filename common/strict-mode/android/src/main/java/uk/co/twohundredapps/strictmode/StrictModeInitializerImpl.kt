package uk.co.twohundredapps.strictmode

import android.os.StrictMode
import javax.inject.Inject

internal class StrictModeInitializerImpl @Inject constructor() : StrictModeInitializer {
    override fun init() {
        StrictMode.setThreadPolicy(
            StrictMode.ThreadPolicy.Builder()
                .detectAll()
                .penaltyDeathOnNetwork()
                .penaltyLog()
                .build()
        )

        StrictMode.setVmPolicy(
            StrictMode.VmPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .build()
        )
    }
}
