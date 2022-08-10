package uk.co.twohundredapps.configuration.data.network

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import uk.co.twohundredapps.api.NotCachedException
import uk.co.twohundredapps.configuration.data.network.models.`in`.ConfigurationApiJson
import uk.co.twohundredapps.configuration.data.network.models.`in`.ImagesConfigurationApiJson

class ConfigurationMemoryDataSourceImplTest {
    private val sut = ConfigurationMemoryDataSourceImpl()

    @Test
    fun `Given configuration is cached When getting configuration Then it is returned from cache`() {
        // Given
        val configurationApiJson = configurationApiJson()
        sut.setConfiguration(configurationApiJson)

        // When
        val result = runBlocking { sut.getConfiguration() }

        // Then
        assertEquals(configurationApiJson, result.getOrThrow())
    }

    @Test
    fun `Given configuration is not cached When getting configuration Then exception is returned`() {
        // When
        val result = runBlocking { sut.getConfiguration() }

        // Then
        assertTrue(result.exceptionOrNull()!! is NotCachedException)
    }

    private fun configurationApiJson() = ConfigurationApiJson(
        imagesConfiguration = ImagesConfigurationApiJson(
            baseUrl = "http://www.some.base.url.com",
            secureBaseUrl = "https://www.some.base.url.com",
            backdropSizes = listOf("420"),
            logoSizes = emptyList(),
            posterSizes = emptyList(),
            profileSizes = emptyList(),
            stillSizes = emptyList()
        )
    )
}