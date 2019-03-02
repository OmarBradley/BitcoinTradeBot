package omarbradley.com.gopax_api.json

data class BalanceJson(
    val asset: String?,
    val avail: Double?,
    val hold: Int?,
    val pendingWithdrawal: Int?
)