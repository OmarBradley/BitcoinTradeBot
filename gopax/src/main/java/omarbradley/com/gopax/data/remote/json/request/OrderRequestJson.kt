package omarbradley.com.gopax.data.remote.json.request

internal data class OrderRequestJson(
    val type: String,
    val side: String,
    val price: Int,
    val amount: Int,
    val tradingPairName: String
)