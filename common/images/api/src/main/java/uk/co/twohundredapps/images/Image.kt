package uk.co.twohundredapps.images

data class Image(
    val url: String,
    val size: Size,
) {
    sealed class Size {
        data class Width(val dimension: Int) : Size()
        data class Height(val dimension: Int) : Size()
        object Original : Size()
    }
}
