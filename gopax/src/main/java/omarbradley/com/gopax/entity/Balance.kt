package omarbradley.com.gopax.entity

data class Balance(
    val asset: String,
    val avail: Double,
    val hold: Int,
    val pendingWithdrawal: Int
)