package uk.co.twohundredapps.core

import arrow.core.Option
import arrow.core.none
import arrow.core.toOption

fun <T> Result<T>.toOption(onFailure: (Throwable) -> Unit = { }): Option<T> {
    return fold(
        onSuccess = { it.toOption() },
        onFailure = { error ->
            onFailure(error)
            none()
        }
    )
}
