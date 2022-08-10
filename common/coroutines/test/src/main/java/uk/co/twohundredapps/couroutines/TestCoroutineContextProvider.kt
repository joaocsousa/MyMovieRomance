@file:OptIn(ExperimentalCoroutinesApi::class)

package uk.co.twohundredapps.couroutines

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import uk.co.twohundredapps.coroutines.CoroutineContextProvider
import kotlin.coroutines.CoroutineContext

class TestCoroutineContextProvider(
    override val main: CoroutineContext = TestCoroutineDispatcher(),
    override val default: CoroutineContext = TestCoroutineDispatcher(),
    override val io: CoroutineContext = TestCoroutineDispatcher(),
    override val unconfined: CoroutineContext = TestCoroutineDispatcher(),
) : CoroutineContextProvider
