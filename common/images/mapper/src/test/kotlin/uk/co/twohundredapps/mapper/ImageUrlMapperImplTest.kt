package uk.co.twohundredapps.mapper

import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Test
import uk.co.twohundredapps.configuration.models.ConfigurationModel
import uk.co.twohundredapps.couroutines.TestCoroutineContextProvider
import uk.co.twohundredapps.images.Image

class ImageUrlMapperImplTest {
    private val coroutineContextProvider = TestCoroutineContextProvider()
    private val sut = ImageUrlMapperImpl(coroutineContextProvider)

    @Test
    fun `Given an image to format When formatting Then all appropriate sizes are returned`() = runBlockingTest {
        // Given
        val configurationModel = ConfigurationModel(
            baseImageUrl = "https://www.base.image.url.com/",
            logoSizes = listOf("original", "h125", "w250"),
            backdropSizes = emptyList(),
            posterSizes = emptyList(),
            profileSizes = emptyList(),
            stillSizes = emptyList()
        )

        // When
        val result = sut.invoke(
            input = ImageMappingData(configurationModel, imageType = ImageType.Logo, imagePath = "/fast_and_furious.png")
        )

        // Then
        assertEquals(
            listOf(
                Image(url = "https://www.base.image.url.com/original/fast_and_furious.png", size = Image.Size.Original),
                Image(url = "https://www.base.image.url.com/h125/fast_and_furious.png", size = Image.Size.Height(125)),
                Image(url = "https://www.base.image.url.com/w250/fast_and_furious.png", size = Image.Size.Width(250)),
            ),
            result.getOrThrow()
        )
    }
}