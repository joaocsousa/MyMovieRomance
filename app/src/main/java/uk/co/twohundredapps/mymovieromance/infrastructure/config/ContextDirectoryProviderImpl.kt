package uk.co.twohundredapps.mymovieromance.infrastructure.config

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import uk.co.twohundredapps.infrastructure.config.ContextDirectoryProvider
import java.io.File
import javax.inject.Inject

class ContextDirectoryProviderImpl @Inject constructor(
    @ApplicationContext private val context: Context,
) : ContextDirectoryProvider {
    override val cacheDir: File
        get() = context.cacheDir
}
