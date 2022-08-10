package uk.co.twohundredapps.mapper

import kotlinx.coroutines.withContext
import uk.co.twohundredapps.configuration.models.ConfigurationModel
import uk.co.twohundredapps.coroutines.CoroutineContextProvider
import uk.co.twohundredapps.domain.mappers.Mapper
import uk.co.twohundredapps.images.Image
import uk.co.twohundredapps.images.Image.Size.Height
import uk.co.twohundredapps.images.Image.Size.Original
import uk.co.twohundredapps.images.Image.Size.Width
import javax.inject.Inject
import kotlin.Result.Companion.failure
import kotlin.Result.Companion.success

interface ImageUrlMapper : Mapper<ImageMappingData, Result<List<Image>>>

internal class ImageUrlMapperImpl @Inject constructor(
    private val coroutineContextProvider: CoroutineContextProvider,
) : ImageUrlMapper {
    override suspend fun invoke(input: ImageMappingData): Result<List<Image>> {
        return withContext(coroutineContextProvider.io) {
            val urlPath = input.imagePath
            if (urlPath.isNullOrBlank()) {
                failure(IllegalArgumentException("no image path!"))
            } else {
                success(
                    formatUrl(configuration = input.configuration, imageType = input.imageType, path = urlPath)
                )
            }
        }
    }

    private fun formatUrl(configuration: ConfigurationModel, imageType: ImageType, path: String): List<Image> {
        return when (imageType) {
            ImageType.Backdrop -> configuration.backdropSizes
            ImageType.Logo -> configuration.logoSizes
            ImageType.Poster -> configuration.posterSizes
            ImageType.Profile -> configuration.profileSizes
            ImageType.Still -> configuration.profileSizes
        }.mapNotNull { sizeTxt ->
            when {
                sizeTxt.lowercase() == "original" -> Original
                "h\\d+".toRegex().matches(sizeTxt) -> Height(dimension = sizeTxt.filter { it.isDigit() }.toInt())
                "w\\d+".toRegex().matches(sizeTxt) -> Width(dimension = sizeTxt.filter { it.isDigit() }.toInt())
                else -> null
            }?.let { size ->
                Image(
                    url = "${configuration.baseImageUrl}$sizeTxt$path",
                    size = size
                )
            }
        }
    }
}
