package omarbradley.com.gopax.entity.resopnse

import omarbradley.com.gopax.entity.Side
import omarbradley.com.gopax.entity.Status
import omarbradley.com.gopax.entity.Type
import org.joda.time.DateTime

data class Order(
    val id: String,
    val status: Status,
    val price: Int,
    val amount: Int,
    val remaining: Int,
    val tradingPairName: String,
    val side: Side,
    val type: Type,
    val createdAt: DateTime
)
