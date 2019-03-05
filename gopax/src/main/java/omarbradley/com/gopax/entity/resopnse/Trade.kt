package omarbradley.com.gopax.entity.resopnse

import omarbradley.com.gopax.entity.Side
import org.joda.time.DateTime

internal data class Trade(
    val id: Int,
    val orderId: Int,
    val baseAmount: Double,
    val quoteAmount: Double,
    val fee: Int,
    val price: Int,
    val timestamp : DateTime,
    val side: Side,
    val tradingPairName: String
)