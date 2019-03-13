package omarbradley.com.gopax.data.repository

import omarbradley.com.gopax.entity.AssetType
import omarbradley.com.gopax.entity.requset.OrderRequest
import omarbradley.com.gopax.entity.requset.TradeRequest
import omarbradley.com.gopax.entity.resopnse.Balance
import omarbradley.com.gopax.entity.resopnse.Order
import omarbradley.com.gopax.entity.resopnse.Trade

interface AuthRepository {

    suspend fun getBalances(apiKey: String, secretKey: String): List<Balance>

    suspend fun getBalance(apiKey: String, secretKey: String, assetType: AssetType): List<Balance>

    suspend fun getOrders(apiKey: String, secretKey: String): List<Order>

    suspend fun getOrder(apiKey: String, secretKey: String, orderId: String): Order

    suspend fun postOrder(apiKey: String, secretKey: String, orderRequest: OrderRequest): Order

    suspend fun deleteOrder(apiKey: String, secretKey: String, orderId: String)

    suspend fun getTrades(apiKey: String, secretKey: String, tradeRequest: TradeRequest): List<Trade>

}
