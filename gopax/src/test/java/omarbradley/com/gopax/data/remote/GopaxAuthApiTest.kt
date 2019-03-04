package omarbradley.com.gopax.data.remote

import io.kotlintest.extensions.TestListener
import io.kotlintest.shouldBe
import io.kotlintest.specs.DescribeSpec
import omarbradley.com.gopax.di.TestDiListener
import omarbradley.com.common.util.HttpMethod
import omarbradley.com.common.util.timeSecond
import omarbradley.com.gopax.data.remote.api.GopaxApi
import omarbradley.com.gopax.data.remote.api.Header
import omarbradley.com.gopax.data.remote.api.Signature
import omarbradley.com.gopax.data.remote.api.createHeaders

class GopaxAuthApiTest : DescribeSpec({

    /**
     * 실제 내 계정 api 키와 secret 임, 테스트에만 이용하자
     */
    val apiKey = ""
    val secretKey = ""

    val api: GopaxApi by lazy {
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
                response.isSuccessful shouldBe true
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
                response.isSuccessful shouldBe true
            }
        }
    }

}) {

    override fun listeners(): List<TestListener> = listOf(TestDiListener)

}