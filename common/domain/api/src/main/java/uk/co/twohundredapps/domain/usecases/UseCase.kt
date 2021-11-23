package uk.co.twohundredapps.domain.usecases

import kotlinx.coroutines.flow.Flow

interface UseCase {

    interface AsyncStream<T> : UseCase {
        operator fun invoke(): Flow<T>
    }

    interface Suspending<T> : UseCase {
        suspend operator fun invoke(): T
    }

    interface Parametrized<IN, OUT> : UseCase {
        suspend operator fun invoke(input: IN): OUT
    }
}
