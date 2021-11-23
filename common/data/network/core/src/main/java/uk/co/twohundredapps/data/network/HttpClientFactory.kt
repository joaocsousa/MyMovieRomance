package uk.co.twohundredapps.data.network

import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import okhttp3.Cache
import uk.co.twohundredapps.infrastructure.config.BuildConfigProvider
import uk.co.twohundredapps.infrastructure.config.ContextDirectoryProvider
import uk.co.twohundredapps.logger.Logy
import kotlinx.serialization.json.Json as SerializationJson

internal interface HttpClientFactory {
    fun newInstance(): HttpClient
}

internal class HttpClientFactoryImpl(
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
                logger = object : Logger {
                    override fun log(message: String) {
                        Logy.i(message)
                    }
                }
                level = LogLevel.ALL
            }

            install(DefaultRequest) {
                parameter("api_key", buildConfigProvider.apiKey)
            }
        }
    }
}
