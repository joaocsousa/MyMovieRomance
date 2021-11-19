package uk.co.twohundredapps.coroutines

import kotlin.coroutines.CoroutineContext

interface CoroutineContextProvider {
    val main: CoroutineContext
    val default: CoroutineContext
    val io: CoroutineContext
    val unconfined: CoroutineContext
}
