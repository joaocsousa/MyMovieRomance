package uk.co.twohundredapps.mymovieromance.infrastructure.config

import uk.co.twohundredapps.infrastructure.config.BaseApiUrlProvider
import javax.inject.Inject

class BaseApiUrlProviderImpl @Inject constructor() : BaseApiUrlProvider {
    override val baseUrl: String
        get() = "https://api.themoviedb.org/3"
}
