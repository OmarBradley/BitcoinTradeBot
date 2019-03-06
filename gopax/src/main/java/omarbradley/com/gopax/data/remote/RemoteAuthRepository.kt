package omarbradley.com.gopax.data.remote

import omarbradley.com.common.util.HttpMethod
import omarbradley.com.common.util.toJsonString
import omarbradley.com.gopax.data.AuthRepository
import omarbradley.com.gopax.data.remote.api.GopaxApi
import omarbradley.com.gopax.data.remote.header.createHeaders
import omarbradley.com.gopax.data.remote.mapper.request.BalanceMapper
import omarbradley.com.gopax.data.remote.mapper.request.OrderMapper
import omarbradley.com.gopax.data.remote.mapper.request.TradeMapper
import omarbradley.com.gopax.data.remote.mapper.response.OrderRequestMapper
import omarbradley.com.gopax.entity.AssetType
import omarbradley.com.gopax.entity.requset.OrderRequest
import omarbradley.com.gopax.entity.requset.TradeRequest
import omarbradley.com.gopax.entity.requset.toQueryMap
import omarbradley.com.gopax.entity.resopnse.Balance
import omarbradley.com.gopax.entity.resopnse.Order
import omarbradley.com.gopax.entity.resopnse.Trade

internal class RemoteAuthRepository(
    private val api: GopaxApi,
    private val apiKey: String,
    private val secretKey: String
) : AuthRepository {

    override suspend fun getBalances(): List<Balance> =
        api.getBalances(createHeaders(secretKey, apiKey, HttpMethod.GET, "/balances"))
            .await()
            .map(BalanceMapper::toEntity)

    override suspend fun getBalance(assetType: AssetType): List<Balance> =
        api.getBalance(createHeaders(secretKey, apiKey, HttpMethod.GET, "/balances/${assetType.id}"), assetType.id)
            .await()
            .map(BalanceMapper::toEntity)


    override suspend fun getOrders(): List<Order> =
        api.getOrders(createHeaders(secretKey, apiKey, HttpMethod.GET, "/orders"))
            .await()
            .map(OrderMapper::toEntity)

    override suspend fun getOrder(orderId: String): Order =
        api.getOrder(createHeaders(secretKey, apiKey, HttpMethod.GET, "/orders/$orderId"), orderId)
            .await()
            .run { OrderMapper.toEntity(this) }

    override suspend fun postOrder(orderRequest: OrderRequest): Order =
        api.postOrder(
            createHeaders(secretKey, apiKey, HttpMethod.POST, "/orders", body = orderRequest.toJsonString()),
            OrderRequestMapper.toData(orderRequest)
        ).await()
            .run { OrderMapper.toEntity(this) }

    override suspend fun deleteOrder(orderId: String) =
        api.deleteOrder(createHeaders(secretKey, apiKey, HttpMethod.DELETE, "/orders$orderId"), orderId)
            .await()

    override suspend fun getTrades(tradeRequest: TradeRequest): List<Trade> =
        api.getTrades(createHeaders(secretKey, apiKey, HttpMethod.GET, "/trades"), tradeRequest.toQueryMap())
            .await()
            .map(TradeMapper::toEntity)

}
