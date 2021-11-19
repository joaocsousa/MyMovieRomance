package uk.co.twohundredapps.mymovieromance.infrastructure.config

import android.content.Context
import uk.co.twohundredapps.infrastructure.config.ContextDirectoryProvider
import java.io.File

class ContextDirectoryProviderImpl(
    private val context: Context,
) : ContextDirectoryProvider {
    override val cacheDir: File
        get() = context.cacheDir
}
