package omarbradley.com.gopax.data.remote.api

import kotlinx.coroutines.Deferred
import omarbradley.com.gopax.data.remote.json.request.OrderRequestJson
import omarbradley.com.gopax.data.remote.json.resopnse.*
import retrofit2.http.*

internal interface Api {

    /**
     * auth-api
     */

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

    /**
     * non-auth api
     */

    @GET("/assets")
    fun getAssets(): Deferred<List<AssetJson>>

    @GET("/trading-pairs")
    fun getTradingPairs(): Deferred<List<TradingPairJson>>

    @GET("/trading-pairs/{TradingPair}/ticker")
    fun getTicker(@Path("TradingPair") tradingPair: String): Deferred<TickerJson>

    @GET("/trading-pairs/{TradingPair}/book")
    fun getBook(@Path("TradingPair") tradingPair: String): Deferred<BookJson>

    @GET("/trading-pairs/{TradingPair}/trades")
    fun getTrades(@Path("TradingPair") tradingPair: String): Deferred<List<TradeJson>>

    /**
     * 1. 최근 체결 거래 조회하기
     * 2. 최근 24시간 통계 조회하기
     * 3. 과거 기록 조회하기
     * 4. 모든 거래쌍의 최근 24시간 통계 조회하기
     * 이 부분은 필요하면 만들기
     */
}
