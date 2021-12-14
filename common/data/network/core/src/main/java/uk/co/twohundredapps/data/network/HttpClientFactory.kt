package uk.co.twohundredapps.data.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.features.DefaultRequest
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logging
import io.ktor.client.request.parameter
import okhttp3.Cache
import uk.co.twohundredapps.infrastructure.config.BuildConfigProvider
import uk.co.twohundredapps.infrastructure.config.ContextDirectoryProvider
import javax.inject.Inject
import kotlinx.serialization.json.Json as SerializationJson

internal interface HttpClientFactory {
    fun newInstance(): HttpClient
}

internal class HttpClientFactoryImpl @Inject constructor(
    private val buildConfigProvider: BuildConfigProvider,
    private val contextDirectoryProvider: ContextDirectoryProvider,
) : HttpClientFactory {

    override fun newInstance(): HttpClient {
        return HttpClient(OkHttp) {
            engine {
                config {
                    cache(Cache(directory = contextDirectoryProvider.cacheDir, maxSize = 10 * 1024 * 1024)) // 10MB
                }
            }

            install(JsonFeature) {
                serializer = KotlinxSerializer(
                    SerializationJson {
                        prettyPrint = true
                        isLenient = true
                        ignoreUnknownKeys = true
                    }
                )
            }

            install(Logging) {
                level = LogLevel.INFO
            }

            install(DefaultRequest) {
                parameter("api_key", buildConfigProvider.apiKey)
            }
        }
    }
}
