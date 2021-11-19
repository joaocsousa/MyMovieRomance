package uk.co.twohundredapps.infrastructure.config

import java.io.File

interface ContextDirectoryProvider {
    val cacheDir: File
}
