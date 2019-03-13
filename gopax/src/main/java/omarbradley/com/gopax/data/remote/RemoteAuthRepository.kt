package omarbradley.com.gopax.data.remote

import omarbradley.com.common.util.HttpMethod
import omarbradley.com.common.util.toJsonString
import omarbradley.com.gopax.data.remote.api.AuthApi
import omarbradley.com.gopax.data.remote.header.createHeaders
import omarbradley.com.gopax.data.remote.mapper.request.BalanceMapper
import omarbradley.com.gopax.data.remote.mapper.request.OrderMapper
import omarbradley.com.gopax.data.remote.mapper.request.TradeMapper
import omarbradley.com.gopax.data.remote.mapper.response.OrderRequestMapper
import omarbradley.com.gopax.data.repository.AuthRepository
import omarbradley.com.gopax.entity.AssetType
import omarbradley.com.gopax.entity.requset.OrderRequest
import omarbradley.com.gopax.entity.requset.TradeRequest
import omarbradley.com.gopax.entity.requset.toQueryMap
import omarbradley.com.gopax.entity.resopnse.Balance
import omarbradley.com.gopax.entity.resopnse.Order
import omarbradley.com.gopax.entity.resopnse.Trade

class RemoteAuthRepository(
    private val api: AuthApi
) : AuthRepository {

    override suspend fun getBalances(apiKey: String, secretKey: String): List<Balance> =
        api.getBalances(createHeaders(secretKey, apiKey, HttpMethod.GET, "/balances"))
            .await()
            .map(BalanceMapper::toEntity)

    override suspend fun getBalance(apiKey: String, secretKey: String, assetType: AssetType): List<Balance> =
        api.getBalance(createHeaders(secretKey, apiKey, HttpMethod.GET, "/balances/${assetType.id}"), assetType.id)
            .await()
            .map(BalanceMapper::toEntity)

    override suspend fun getOrders(apiKey: String, secretKey: String): List<Order> =
        api.getOrders(createHeaders(secretKey, apiKey, HttpMethod.GET, "/orders"))
            .await()
            .map(OrderMapper::toEntity)

    override suspend fun getOrder(apiKey: String, secretKey: String, orderId: String): Order =
        api.getOrder(createHeaders(secretKey, apiKey, HttpMethod.GET, "/orders/$orderId"), orderId)
            .await()
            .run { OrderMapper.toEntity(this) }

    override suspend fun postOrder(apiKey: String, secretKey: String, orderRequest: OrderRequest): Order =
        api.postOrder(
            createHeaders(secretKey, apiKey, HttpMethod.POST, "/orders", body = orderRequest.toJsonString()),
            OrderRequestMapper.toData(orderRequest)
        ).await()
            .run { OrderMapper.toEntity(this) }

    override suspend fun deleteOrder(apiKey: String, secretKey: String, orderId: String) =
        api.deleteOrder(createHeaders(secretKey, apiKey, HttpMethod.DELETE, "/orders$orderId"), orderId)
            .await()

    override suspend fun getTrades(apiKey: String, secretKey: String, tradeRequest: TradeRequest): List<Trade> =
        api.getTrades(createHeaders(secretKey, apiKey, HttpMethod.GET, "/trades"), tradeRequest.toQueryMap())
            .await()
            .map(TradeMapper::toEntity)

}
