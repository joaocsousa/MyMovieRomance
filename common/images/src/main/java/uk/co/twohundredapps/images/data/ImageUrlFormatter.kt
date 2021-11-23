package uk.co.twohundredapps.images.data

import kotlinx.coroutines.withContext
import uk.co.twohundredapps.configuration.data.network.ConfigurationRepository
import uk.co.twohundredapps.coroutines.CoroutineContextProvider
import uk.co.twohundredapps.domain.mappers.Mapper
import kotlin.Result.Companion.failure

interface ImageUrlFormatter : Mapper<ImageUrlData, Result<String>>

internal class ImageUrlFormatterImpl(
    private val coroutineContextProvider: CoroutineContextProvider,
    private val configurationRepository: ConfigurationRepository,
) : ImageUrlFormatter {
    override suspend fun invoke(input: ImageUrlData): Result<String> {
        return withContext(coroutineContextProvider.io) {
            if (input.path.isNullOrBlank()) {
                failure(IllegalArgumentException())
            } else {
                formatUrl(imageUrlData = input)
            }
        }
    }

    private suspend fun formatUrl(imageUrlData: ImageUrlData): Result<String> {
        return configurationRepository.getConfiguration().map { configuration ->
            val size = when (imageUrlData.imageType) {
                ImageType.Backdrop -> configuration.imagesConfiguration.backdropSizes[1]
                ImageType.Logo -> configuration.imagesConfiguration.logoSizes[1]
                ImageType.Poster -> configuration.imagesConfiguration.posterSizes[1]
                ImageType.Profile -> configuration.imagesConfiguration.profileSizes[1]
                ImageType.Still -> configuration.imagesConfiguration.profileSizes[1]
            }
            "${configuration.imagesConfiguration.secureBaseUrl}$size${imageUrlData.path}"
        }
    }
}
