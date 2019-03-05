package omarbradley.com.gopax.entity.resopnse

import org.joda.time.DateTime

internal data class Ticker(
    val price: Int,
    val ask: Int,
    val bid: Int,
    val volume: Double,
    val time: DateTime
)