package omarbradley.com.gopax.data.remote

import io.kotlintest.shouldNotBe
import io.kotlintest.specs.DescribeSpec
import omarbradley.com.common.util.HttpMethod
import omarbradley.com.common.util.timeSecond
import omarbradley.com.gopax.data.remote.api.AuthApi
import omarbradley.com.gopax.data.remote.header.Header
import omarbradley.com.gopax.data.remote.header.Signature
import omarbradley.com.gopax.data.remote.header.createHeaders

class AuthApiTest : DescribeSpec({

    /**
     * 실제 내 계정 authApi 키와 secret 임, 테스트에만 이용하자
     */
    val apiKey = ""
    val secretKey = ""

    val api: AuthApi by lazy {
        authApi
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

})
