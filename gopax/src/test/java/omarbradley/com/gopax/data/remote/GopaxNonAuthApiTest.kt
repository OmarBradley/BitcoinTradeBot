package omarbradley.com.gopax.data.remote

import io.kotlintest.extensions.TestListener
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import omarbradley.com.gopax.data.remote.api.GopaxApi
import omarbradley.com.gopax.di.TestDiListener

class GopaxNonAuthApiTest : StringSpec({

    val api: GopaxApi by lazy {
        TestDiListener.api
    }

    "getAssets api가 성공적으로 응답이 된다"{
        val response = api.getAssets().await()
        response.isSuccessful shouldBe true
    }

    "getTradingPairs api가 성공적으로 응답이 된다"{
        val response = api.getTradingPairs().await()
        response.isSuccessful shouldBe true
    }

    "getTicker api가 성공적으로 응답이 된다"{
        val exampleTradingPair = "BTC-KRW"
        val response = api.getTicker(exampleTradingPair).await()
        response.isSuccessful shouldBe true
    }

    "getBook api가 성공적으로 응답이 된다"{
        val exampleTradingPair = "BTC-KRW"
        val response = api.getBook(exampleTradingPair).await()
        response.isSuccessful shouldBe true
    }

    "getTrades api가 성공적으로 응답이 된다"{
        val exampleTradingPair = "BTC-KRW"
        val response = api.getTrades(exampleTradingPair).await()
        response.isSuccessful shouldBe true
    }

}) {

    override fun listeners(): List<TestListener> = listOf(TestDiListener)

}