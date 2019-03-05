package omarbradley.com.gopax.data.remote.mapper.response

import omarbradley.com.common.domain.Mapper
import omarbradley.com.gopax.data.remote.json.request.TradeRequestJson
import omarbradley.com.gopax.entity.requset.TradeRequest

internal object TradeRequestMapper : Mapper<TradeRequest, TradeRequestJson> {

    override fun toData(entity: TradeRequest): TradeRequestJson =
        TradeRequestJson(entity.limit, entity.pastmax, entity.latestmin, entity.after, entity.before)

    override fun toEntity(data: TradeRequestJson): TradeRequest =
        TradeRequest(data.limit, data.pastmax, data.latestmin, data.after, data.before)
}