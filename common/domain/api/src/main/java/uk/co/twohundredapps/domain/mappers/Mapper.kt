package uk.co.twohundredapps.domain.mappers

fun interface Mapper<IN, OUT> {
    operator fun invoke(input: IN): OUT
}