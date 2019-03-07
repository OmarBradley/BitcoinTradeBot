package omarbradley.com.gopax.data.remote.json.request

data class TradeRequestJson(
    val limit: Int?,
    val pastmax: Int?,
    val latestmin: Int?,
    val after: Long?,
    val before: Long?
)