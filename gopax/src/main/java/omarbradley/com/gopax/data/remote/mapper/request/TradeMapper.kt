package omarbradley.com.gopax.data.remote.mapper.request

import omarbradley.com.common.data.Mapper
import omarbradley.com.common.util.toDateTime
import omarbradley.com.gopax.data.remote.json.resopnse.TradeJson
import omarbradley.com.gopax.entity.resopnse.Trade
import omarbradley.com.gopax.entity.toSide

object TradeMapper : Mapper<Trade, TradeJson> {

    override fun toData(entity: Trade): TradeJson =
        TradeJson(
            entity.id,
            entity.orderId,
            entity.baseAmount,
            entity.quoteAmount,
            entity.fee,
            entity.price,
            entity.timestamp.toString(),
            entity.side.jsonString,
            entity.tradingPairName
        )

    override fun toEntity(data: TradeJson): Trade =
        Trade(
            data.id,
            data.orderId,
            data.baseAmount,
            data.quoteAmount,
            data.fee,
            data.price,
            data.timestamp.toDateTime(),
            data.side.toSide(),
            data.tradingPairName
        )

}