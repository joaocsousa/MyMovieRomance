package uk.co.twohundredapps.images.data

sealed interface ImageType {
    object Backdrop : ImageType
    object Logo : ImageType
    object Poster : ImageType
    object Profile : ImageType
    object Still : ImageType
}
