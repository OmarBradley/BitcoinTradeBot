package omarbradley.com.gopax.data.remote.mapper.response

import omarbradley.com.common.domain.Mapper
import omarbradley.com.gopax.data.remote.json.request.OrderRequestJson
import omarbradley.com.gopax.entity.requset.OrderRequest
import omarbradley.com.gopax.entity.toSide
import omarbradley.com.gopax.entity.toType

object OrderRequestMapper : Mapper<OrderRequest, OrderRequestJson> {

    override fun toData(entity: OrderRequest): OrderRequestJson =
        OrderRequestJson(
            entity.type.jsonString,
            entity.side.jsonString,
            entity.price,
            entity.amount,
            entity.tradingPairName
        )

    override fun toEntity(data: OrderRequestJson): OrderRequest =
        OrderRequest(
            data.type.toType(),
            data.side.toSide(),
            data.price,
            data.amount,
            data.tradingPairName
        )
}