package uk.co.twohundredapps.coroutines

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class DefaultCoroutineContextProvider : CoroutineContextProvider

interface CoroutineContextProvider {
    val main: CoroutineContext get() = Dispatchers.Main
    val default: CoroutineContext get() = Dispatchers.Default
    val io: CoroutineContext get() = Dispatchers.IO
    val unconfined: CoroutineContext get() = Dispatchers.Unconfined
}