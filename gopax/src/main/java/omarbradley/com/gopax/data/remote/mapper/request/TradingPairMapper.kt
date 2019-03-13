package omarbradley.com.gopax.data.remote.mapper.request

import omarbradley.com.common.data.Mapper
import omarbradley.com.gopax.data.remote.json.resopnse.TradingPairJson
import omarbradley.com.gopax.entity.resopnse.TradingPair
import omarbradley.com.gopax.entity.toAssetType

object TradingPairMapper : Mapper<TradingPair, TradingPairJson> {

    override fun toData(entity: TradingPair): TradingPairJson =
        TradingPairJson(
            entity.name,
            entity.baseAsset.id,
            entity.quoteAsset.id
        )

    override fun toEntity(data: TradingPairJson): TradingPair =
        TradingPair(
            data.name,
            data.baseAsset.toAssetType(),
            data.quoteAsset.toAssetType()
        )
}