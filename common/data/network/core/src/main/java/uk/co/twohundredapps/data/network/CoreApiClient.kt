package uk.co.twohundredapps.data.network

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import uk.co.twohundredapps.infrastructure.config.BaseApiUrlProvider
import javax.inject.Inject

class CoreApiClient @Inject internal constructor(
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
