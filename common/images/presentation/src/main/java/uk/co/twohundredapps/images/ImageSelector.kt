package uk.co.twohundredapps.images

import arrow.core.Option
import arrow.core.none

fun interface ImageSelector {
    operator fun invoke(id: String, images: List<Image>, targetSize: TargetSize): Option<Image>
}

internal class ImageSelectorImpl : ImageSelector {
    override operator fun invoke(id: String, images: List<Image>, targetSize: TargetSize): Option<Image> {
        return none()
    }
}
