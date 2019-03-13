package omarbradley.com.gopax.data.remote.api

import kotlinx.coroutines.Deferred
import omarbradley.com.gopax.data.remote.json.resopnse.*
import retrofit2.http.GET
import retrofit2.http.Path

interface NonAuthApi {

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

}
