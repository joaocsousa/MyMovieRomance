package uk.co.twohundredapps.couroutines

import kotlinx.coroutines.Dispatchers
import uk.co.twohundredapps.coroutines.CoroutineContextProvider
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

internal class DefaultCoroutineContextProvider @Inject constructor() : CoroutineContextProvider {
    override val main: CoroutineContext
        get() = Dispatchers.Main
    override val default: CoroutineContext
        get() = Dispatchers.Default
    override val io: CoroutineContext
        get() = Dispatchers.IO
    override val unconfined: CoroutineContext
        get() = Dispatchers.Unconfined
}
