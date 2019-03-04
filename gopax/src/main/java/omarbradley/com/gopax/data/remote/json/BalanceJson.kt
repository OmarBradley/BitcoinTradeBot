package omarbradley.com.gopax.data.remote.json

data class BalanceJson(
    val asset: String,
    val avail: Double,
    val hold: Int,
    val pendingWithdrawal: Int
)

