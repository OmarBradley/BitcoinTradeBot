package omarbradley.com.gopax.entity.requset

data class TradeRequest(
    val limit: Int?,
    val pastmax: Int?,
    val latestmin: Int?,
    val after: Long?,
    val before: Long?
)

fun TradeRequest.toQueryMap() =
    mapOf(
        "limit" to limit.toString(),
        "pastmax" to pastmax.toString(),
        "latestmin" to latestmin.toString(),
        "after" to after.toString(),
        "before" to before.toString()
    )
