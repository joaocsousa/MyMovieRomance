package uk.co.twohundredapps.mymovieromance.infrastructure.config

import uk.co.twohundredapps.infrastructure.config.BaseApiUrlProvider

class BaseApiUrlProviderImpl : BaseApiUrlProvider {
    override val baseUrl: String
        get() = "https://api.themoviedb.org/3"
}
