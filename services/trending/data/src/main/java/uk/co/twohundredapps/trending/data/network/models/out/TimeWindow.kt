package uk.co.twohundredapps.trending.data.network.models.out

sealed class TimeWindow(val name: String) {
    object Day : TimeWindow("day")
}
