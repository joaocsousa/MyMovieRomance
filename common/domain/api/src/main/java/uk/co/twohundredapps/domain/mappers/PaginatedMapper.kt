package uk.co.twohundredapps.domain.mappers

import uk.co.twohundredapps.domain.models.Paginated
import uk.co.twohundredapps.data.network.models.Paginated as NetworkPaginated

abstract class PaginatedMapper<IN, OUT> constructor(
    private val itemMapper: Mapper<IN, OUT>
) : Mapper<NetworkPaginated<IN>, Paginated<OUT>> {
    override fun invoke(input: NetworkPaginated<IN>): Paginated<OUT> {
        return Paginated(
            page = input.page,
            totalPages = input.totalPages,
            results = input.results.map { itemMapper(it) }
        )
    }
}
