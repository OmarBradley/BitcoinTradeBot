package omarbradley.com.gopax.data.remote.json.resopnse

data class TickerJson(
    val price: Int,
    val ask: Int,
    val bid: Int,
    val volume: Double,
    val time: String
)
