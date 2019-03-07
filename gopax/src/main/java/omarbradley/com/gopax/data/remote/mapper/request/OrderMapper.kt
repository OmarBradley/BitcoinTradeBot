package omarbradley.com.gopax.data.remote.mapper.request

import omarbradley.com.common.data.Mapper
import omarbradley.com.common.util.toDateTime
import omarbradley.com.gopax.data.remote.json.resopnse.OrderJson
import omarbradley.com.gopax.entity.resopnse.Order
import omarbradley.com.gopax.entity.toSide
import omarbradley.com.gopax.entity.toStatus
import omarbradley.com.gopax.entity.toType

object OrderMapper : Mapper<Order, OrderJson> {

    override fun toData(entity: Order): OrderJson =
        OrderJson(
            entity.id,
            entity.status.jsonString,
            entity.price,
            entity.amount,
            entity.remaining,
            entity.tradingPairName,
            entity.side.jsonString,
            entity.type.jsonString,
            entity.createdAt.toString()
        )

    override fun toEntity(data: OrderJson): Order =
        Order(
            data.id,
            data.status.toStatus(),
            data.price,
            data.amount,
            data.remaining,
            data.tradingPairName,
            data.side.toSide(),
            data.type.toType(),
            data.createdAt.toDateTime()
        )
}