package omarbradley.com.gopax.data.remote.api

import kotlinx.coroutines.Deferred
import omarbradley.com.gopax.data.remote.json.request.OrderRequestJson
import omarbradley.com.gopax.data.remote.json.resopnse.BalanceJson
import omarbradley.com.gopax.data.remote.json.resopnse.OrderJson
import omarbradley.com.gopax.data.remote.json.resopnse.TradeJson
import retrofit2.http.*

interface AuthApi {

    @GET("/balances")
    fun getBalances(@HeaderMap headers: Map<String, String>): Deferred<List<BalanceJson>>

    @GET("/balances/{assetName}")
    fun getBalance(@HeaderMap headers: Map<String, String>, @Path("assetName") assetName: String): Deferred<List<BalanceJson>>

    @GET("/orders")
    fun getOrders(@HeaderMap headers: Map<String, String>): Deferred<List<OrderJson>>

    @GET("/orders/{orderId}")
    fun getOrder(@HeaderMap headers: Map<String, String>, @Path("orderId") orderId: String): Deferred<OrderJson>

    @POST("/orders")
    fun postOrder(@HeaderMap headers: Map<String, String>, @Body order: OrderRequestJson): Deferred<OrderJson>

    @DELETE("/orders/{orderId}")
    fun deleteOrder(@HeaderMap headers: Map<String, String>, @Path("orderId") orderId: String): Deferred<Nothing>

    @GET("/trades")
    fun getTrades(@HeaderMap headers: Map<String, String>, @QueryMap queries: Map<String, String>): Deferred<List<TradeJson>>

}
