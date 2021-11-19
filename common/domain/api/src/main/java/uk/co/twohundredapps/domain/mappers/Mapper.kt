package uk.co.twohundredapps.domain.mappers

fun interface Mapper<IN, OUT> {
    suspend operator fun invoke(input: IN): OUT
}