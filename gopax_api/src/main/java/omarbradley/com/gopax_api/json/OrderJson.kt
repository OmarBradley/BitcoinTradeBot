package omarbradley.com.gopax_api.json

data class OrderJson(
    val id: String?,
    val status: String?,
    val price: Int?,
    val amount: Double?,
    val remaining: Int?,
    val tradingPairName: String?,
    val side: String?,
    val type: String?,
    val createdAt: String?
)