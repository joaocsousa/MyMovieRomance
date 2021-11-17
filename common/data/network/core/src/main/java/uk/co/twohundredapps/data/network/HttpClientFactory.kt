package uk.co.twohundredapps.data.network

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.features.observer.*
import io.ktor.client.request.*
import uk.co.twohundredapps.infrastructure.config.BuildConfigProvider
import kotlinx.serialization.json.Json as SerializationJson
import uk.co.twohundredapps.logger.Logger as LocalLogger

internal interface HttpClientFactory {
    fun newInstance(): HttpClient
}

internal class HttpClientFactoryImpl(
    private val buildConfigProvider: BuildConfigProvider,
    private val localLogger: LocalLogger
) : HttpClientFactory {

    override fun newInstance(): HttpClient {
        return HttpClient(Android) {
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
                        localLogger.i(message)
                    }
                }
                level = LogLevel.ALL
            }

            install(ResponseObserver) {
                onResponse { response ->
                    localLogger.d("HTTP status: ${response.status.value}")
                }
            }

            install(DefaultRequest) {
                parameter("api_key", buildConfigProvider.apiKey)
            }
        }
    }
}
