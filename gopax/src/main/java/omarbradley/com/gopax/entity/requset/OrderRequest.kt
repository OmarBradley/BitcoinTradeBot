package omarbradley.com.gopax.entity.requset

import omarbradley.com.gopax.entity.Side
import omarbradley.com.gopax.entity.Type

data class OrderRequest(
    val type: Type,
    val side: Side,
    val price: Int,
    val amount: Int,
    val tradingPairName: String
)