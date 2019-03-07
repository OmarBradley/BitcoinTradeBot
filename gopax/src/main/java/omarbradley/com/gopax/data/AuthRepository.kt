package omarbradley.com.gopax.data

import omarbradley.com.gopax.entity.AssetType
import omarbradley.com.gopax.entity.requset.OrderRequest
import omarbradley.com.gopax.entity.requset.TradeRequest
import omarbradley.com.gopax.entity.resopnse.Balance
import omarbradley.com.gopax.entity.resopnse.Order
import omarbradley.com.gopax.entity.resopnse.Trade

interface AuthRepository {

    suspend fun getBalances(): List<Balance>

    suspend fun getBalance(assetType: AssetType): List<Balance>

    suspend fun getOrders(): List<Order>

    suspend fun getOrder(orderId: String): Order

    suspend fun postOrder(orderRequest: OrderRequest): Order

    suspend fun deleteOrder(orderId: String)

    suspend fun getTrades(tradeRequest: TradeRequest): List<Trade>

}
