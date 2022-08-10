@file:OptIn(ExperimentalCoroutinesApi::class)

package uk.co.twohundredapps.configuration.repositories

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Test
import uk.co.twohundredapps.api.NotCachedException
import uk.co.twohundredapps.configuration.data.network.ConfigurationApi
import uk.co.twohundredapps.configuration.data.network.ConfigurationMemoryDataSource
import uk.co.twohundredapps.configuration.data.network.models.`in`.ConfigurationApiJson
import uk.co.twohundredapps.configuration.data.network.models.`in`.ImagesConfigurationApiJson
import uk.co.twohundredapps.configuration.mappers.ConfigurationApiModelMapper
import uk.co.twohundredapps.configuration.models.ConfigurationModel
import uk.co.twohundredapps.couroutines.TestCoroutineContextProvider

class ConfigurationRepositoryImplTest {
    private val coroutineContextProvider = TestCoroutineContextProvider()
    private val configurationMemoryDataSource = mockk<ConfigurationMemoryDataSource>(relaxUnitFun = true)
    private val configurationApi = mockk<ConfigurationApi>()
    private val configurationApiModelMapper = mockk<ConfigurationApiModelMapper>()
    private val sut = ConfigurationRepositoryImpl(
        coroutineContextProvider = coroutineContextProvider,
        configurationMemoryDataSource = configurationMemoryDataSource,
        configurationApi = configurationApi,
        configurationApiModelMapper = configurationApiModelMapper
    )

    @Test
    fun `Given configuration is cached When fetching configuration Then cached value is returned and not stored`() =
        runBlockingTest(coroutineContextProvider.io) {
            // Given
            val configurationApiJson = configurationApiJson()
            val configurationModel = configurationModel()
            coEvery { configurationMemoryDataSource.getConfiguration() } returns Result.success(configurationApiJson)
            coEvery { configurationApiModelMapper(configurationApiJson) } returns configurationModel

            // When
            val result = sut.getConfiguration()

            // Then
            coVerify(exactly = 0) { configurationMemoryDataSource.setConfiguration(any()) }
            assertEquals(configurationModel, result.getOrThrow())
        }

    @Test
    fun `Given configuration is not cached When fetching configuration Then it is cached, saved and afterwards returned`() =
        runBlockingTest(coroutineContextProvider.io) {
            // Given
            val configurationApiJson = configurationApiJson()
            val configurationModel = configurationModel()
            coEvery { configurationMemoryDataSource.getConfiguration() } returns Result.failure(NotCachedException(""))
            coEvery { configurationApiModelMapper(configurationApiJson) } returns configurationModel
            coEvery { configurationApi.getConfiguration() } returns Result.success(configurationApiJson)

            // When
            val result = sut.getConfiguration()

            // Then
            coVerify(exactly = 1) { configurationMemoryDataSource.setConfiguration(configurationApiJson) }
            assertEquals(configurationModel, result.getOrThrow())
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

    private fun configurationModel() = ConfigurationModel(
        baseImageUrl = "https://www.some.base.url.com",
        backdropSizes = listOf("420"),
        logoSizes = emptyList(),
        posterSizes = emptyList(),
        profileSizes = emptyList(),
        stillSizes = emptyList()
    )
}