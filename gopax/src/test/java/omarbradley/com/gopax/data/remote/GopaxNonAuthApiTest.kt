package omarbradley.com.gopax.data.remote

import io.kotlintest.extensions.TestListener
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.StringSpec
import omarbradley.com.gopax.data.remote.api.Api
import omarbradley.com.gopax.di.TestDiListener

class GopaxNonAuthApiTest : StringSpec({

    val api: Api by lazy {
        TestDiListener.api
    }

    "getAssets api가 성공적으로 응답이 된다"{
        val response = api.getAssets().await()
        response shouldNotBe null
    }

    "getTradingPairs api가 성공적으로 응답이 된다"{
        val response = api.getTradingPairs().await()
        response shouldNotBe null
    }

    "getTicker api가 성공적으로 응답이 된다"{
        val exampleTradingPair = "BTC-KRW"
        val response = api.getTicker(exampleTradingPair).await()
        response shouldNotBe null
    }

    "getBook api가 성공적으로 응답이 된다"{
        val exampleTradingPair = "BTC-KRW"
        val response = api.getBook(exampleTradingPair).await()
        response shouldNotBe null
    }

    "getTrades api가 성공적으로 응답이 된다"{
        val exampleTradingPair = "BTC-KRW"
        val response = api.getTrades(exampleTradingPair).await()
        response shouldNotBe null
    }

}) {

    override fun listeners(): List<TestListener> = listOf(TestDiListener)

}