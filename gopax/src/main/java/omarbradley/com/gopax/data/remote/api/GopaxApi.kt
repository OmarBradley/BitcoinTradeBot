package omarbradley.com.gopax.data.remote.api

import kotlinx.coroutines.Deferred
import omarbradley.com.gopax.data.remote.json.*
import retrofit2.Response
import retrofit2.http.*

interface GopaxApi {

    /**
     * auth-api
     */

    @GET("/balances")
    fun getBalances(@HeaderMap headers: Map<String, String>): Deferred<Response<List<BalanceJson>>>

    @GET("/balances/{assetName}")
    fun getBalance(@HeaderMap headers: Map<String, String>, @Path("assetName") assetName: String): Deferred<Response<List<BalanceJson>>>

    @GET("/orders")
    fun getOrders(@HeaderMap headers: Map<String, String>): Deferred<Response<List<OrderJson>>>

    @GET("/orders/{orderId}")
    fun getOrder(@HeaderMap headers: Map<String, String>, @Path("orderId") orderId: String): Deferred<Response<OrderJson>>

    @POST("/orders")
    fun postOrder(@Body order: OrderJson): Deferred<Response<OrderJson>>

    @DELETE("/orders/{orderId}")
    fun deleteOrder(@HeaderMap headers: Map<String, String>, @Path("orderId") orderId: String): Deferred<Response<Nothing>>

    @GET("/trades")
    fun getTrades(@HeaderMap headers: Map<String, String>, @QueryMap queries: Map<String, String>): Deferred<Response<List<TradeJson>>>

    /**
     * non-auth api
     */

    @GET("/assets")
    fun getAssets(): Deferred<Response<List<AssetJson>>>

    @GET("/trading-pairs")
    fun getTradingPairs(): Deferred<Response<List<TradingPairJson>>>

    @GET("/trading-pairs/{TradingPair}/ticker")
    fun getTicker(@Path("TradingPair") tradingPair: String): Deferred<Response<TickerJson>>

    @GET("/trading-pairs/{TradingPair}/book")
    fun getBook(@Path("TradingPair") tradingPair: String): Deferred<Response<BookJson>>

    @GET("/trading-pairs/{TradingPair}/trades")
    fun getTrades(@Path("TradingPair") tradingPair: String): Deferred<Response<List<TradeJson>>>

    /**
     * 1. 최근 체결 거래 조회하기
     * 2. 최근 24시간 통계 조회하기
     * 3. 과거 기록 조회하기
     * 4. 모든 거래쌍의 최근 24시간 통계 조회하기
     * 이 부분은 필요하면 만들기
     */

}