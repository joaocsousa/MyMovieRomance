package uk.co.twohundredapps.strictmode

import android.os.StrictMode

internal class StrictModeInitializerImpl : StrictModeInitializer {
    override fun init() {
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder()
            .detectAll()
            .penaltyDeathOnNetwork()
            .penaltyLog()
            .build())

        StrictMode.setVmPolicy(StrictMode.VmPolicy.Builder()
            .detectAll()
            .penaltyLog()
            .build())
    }
}