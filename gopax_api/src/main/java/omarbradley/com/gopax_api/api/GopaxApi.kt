package omarbradley.com.gopax_api.api

import kotlinx.coroutines.Deferred
import omarbradley.com.gopax_api.json.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GopaxApi {

    @GET("/assets")
    fun getAssets(): Deferred<Response<List<AssetJson>>>

    @GET("/trading-pairs")
    fun getTradingPairs(): Deferred<Response<List<TradingPairJson>>>

    @GET("/trading-pairs/{TradingPair}/ticker")
    fun getTicker(@Path("TradingPair") tradingPair: String): Deferred<Response<TickerJson>>

    @GET("/trading-pairs/{TradingPair}/book")
    fun getBook(@Path("TradingPair") tradingPair: String): Deferred<Response<BookJson>>

    @GET("/trading-pairs/{TradingPair}/book")
    fun getTrades(@Path("TradingPair") tradingPair: String): Deferred<Response<List<TradeJson>>>

    /**
     * 1. 최근 체결 거래 조회하기
     * 2. 최근 24시간 통계 조회하기
     * 3. 과거 기록 조회하기
     * 4. 모든 거래쌍의 최근 24시간 통계 조회하기
     * 이 부분은 필요하면 만들기
     */

}