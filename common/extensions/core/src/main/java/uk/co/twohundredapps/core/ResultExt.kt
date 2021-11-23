package uk.co.twohundredapps.core

import arrow.core.Option
import arrow.core.toOption

fun <T> optionOf(target: T): Option<T> {
    return target.toOption()
}
