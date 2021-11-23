package uk.co.twohundredapps.data.network

import io.ktor.client.*
import io.ktor.client.request.*
import uk.co.twohundredapps.infrastructure.config.BaseApiUrlProvider

class CoreApiClient internal constructor(
    val httpClient: HttpClient,
    val baseApiUrlProvider: BaseApiUrlProvider,
) {
    suspend inline fun <reified T> get(
        path: String,
        params: Map<String, Any?> = emptyMap(),
    ): T = httpClient.get(urlString = "${baseApiUrlProvider.baseUrl}/$path") {
        params.onEach { (key: String, value: Any?) ->
            parameter(key, value)
        }
    }
}
