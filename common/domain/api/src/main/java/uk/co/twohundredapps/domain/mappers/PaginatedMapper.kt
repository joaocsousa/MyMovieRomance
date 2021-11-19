package uk.co.twohundredapps.domain.mappers

import kotlinx.coroutines.withContext
import uk.co.twohundredapps.coroutines.CoroutineContextProvider
import uk.co.twohundredapps.domain.models.Paginated
import uk.co.twohundredapps.data.network.models.Paginated as NetworkPaginated

abstract class PaginatedMapper<IN, OUT> constructor(
    private val coroutineContextProvider: CoroutineContextProvider,
    private val itemMapper: Mapper<IN, OUT>
) : Mapper<NetworkPaginated<IN>, Paginated<OUT>> {
    override suspend fun invoke(input: NetworkPaginated<IN>): Paginated<OUT> {
        return withContext(coroutineContextProvider.default) {
            Paginated(
                page = input.page,
                totalPages = input.totalPages,
                results = input.results.map { itemMapper(it) }
            )
        }
    }
}
