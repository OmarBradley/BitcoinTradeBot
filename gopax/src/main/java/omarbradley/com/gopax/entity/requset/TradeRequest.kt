package omarbradley.com.gopax.entity.requset

internal data class TradeRequest(
    val limit: Int?,
    val pastmax: Int?,
    val latestmin: Int?,
    val after: Long?,
    val before: Long?
)

internal fun TradeRequest.toQueryMap() =
    mapOf(
        "limit" to limit.toString(),
        "pastmax" to pastmax.toString(),
        "latestmin" to latestmin.toString(),
        "after" to after.toString(),
        "before" to before.toString()
    )
