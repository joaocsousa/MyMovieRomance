package uk.co.twohundredapps.data.network

import io.ktor.client.*
import io.ktor.client.request.*
import uk.co.twohundredapps.infrastructure.config.BaseApiUrlProvider

class CoreApiClient internal constructor(
    val httpClient: HttpClient,
    val baseApiUrlProvider: BaseApiUrlProvider
) {
    suspend inline fun <reified T> get(
        path: String,
        block: HttpRequestBuilder.() -> Unit = {}
    ): T = httpClient.get(urlString = "${baseApiUrlProvider.baseUrl}/$path") {
        block()
    }
}
