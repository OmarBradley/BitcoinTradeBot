package omarbradley.com.gopax.data.remote.json.resopnse

data class OrderJson(
    val id: String,
    val status: String,
    val price: Int,
    val amount: Int,
    val remaining: Int,
    val tradingPairName: String,
    val side: String,
    val type: String,
    val createdAt: String
)