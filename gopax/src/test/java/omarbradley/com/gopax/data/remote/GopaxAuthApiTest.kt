package omarbradley.com.gopax.data.remote

import io.kotlintest.extensions.TestListener
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.DescribeSpec
import omarbradley.com.common.util.HttpMethod
import omarbradley.com.common.util.timeSecond
import omarbradley.com.gopax.data.remote.api.Api
import omarbradley.com.gopax.data.remote.header.Header
import omarbradley.com.gopax.data.remote.header.Signature
import omarbradley.com.gopax.data.remote.header.createHeaders
import omarbradley.com.gopax.di.TestDiListener

class GopaxAuthApiTest : DescribeSpec({

    /**
     * 실제 내 계정 gopaxAuthApi 키와 secret 임, 테스트에만 이용하자
     */
    val apiKey = "e1d1a326-99b9-45cc-9847-0f719143668b"
    val secretKey = "AizZfxQyy2gqDrnrYSSXSkaPGYxjLfDWFrxSLf/Sqa9BJOrWizXdhdaXdL2vrnqXynyTIB6QiiM1QXzcIrJSHA=="

    val api: Api by lazy {
        TestDiListener.api
    }

    describe(".getBalances") {

        context("인증 Header가 주어질 때") {
            val signature = Signature(
                secret = secretKey,
                method = HttpMethod.GET,
                requestPath = "/balances",
                nonce = timeSecond
            )

            val headers = Header(
                apiKey = apiKey,
                signature = signature
            ).createHeaders()

            it("getBalances api가 성공적으로 응답이 된다") {
                val response = api.getBalances(headers).await()
                response shouldNotBe null
            }
        }
    }

    describe(".getOrders") {

        context("인증 Header가 주어질 때") {
            val signature = Signature(
                secret = secretKey,
                method = HttpMethod.GET,
                requestPath = "/orders",
                nonce = timeSecond
            )

            val headers = Header(
                apiKey = apiKey,
                signature = signature
            ).createHeaders()

            it("getOrders api가 성공적으로 응답이 된다").config(enabled = true) {
                val response = api.getOrders(headers).await()
                response shouldNotBe null
            }
        }
    }

}) {

    override fun listeners(): List<TestListener> = listOf(TestDiListener)

}