package omarbradley.com.gopax.data.remote.json.resopnse

data class BalanceJson(
    val asset: String,
    val avail: Double,
    val hold: Int,
    val pendingWithdrawal: Int
)

