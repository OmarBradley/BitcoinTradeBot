package omarbradley.com.gopax.entity.resopnse

import omarbradley.com.gopax.entity.AssetType

data class TradingPair(
    val name: String,
    val baseAsset: AssetType,
    val quoteAsset: AssetType
)