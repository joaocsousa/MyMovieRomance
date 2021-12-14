package uk.co.twohundredapps.strictmode

import javax.inject.Inject

internal class StrictModeInitializerNoop @Inject constructor() : StrictModeInitializer {
    override fun init() {
        // no-op
    }
}
