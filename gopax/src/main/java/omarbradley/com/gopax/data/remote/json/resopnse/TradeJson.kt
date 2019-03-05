package omarbradley.com.gopax.data.remote.json.resopnse

internal data class TradeJson(
    val id: Int,
    val orderId: Int,
    val baseAmount: Double,
    val quoteAmount: Double,
    val fee: Int,
    val price: Int,
    val timestamp: String,
    val side: String,
    val tradingPairName: String
)