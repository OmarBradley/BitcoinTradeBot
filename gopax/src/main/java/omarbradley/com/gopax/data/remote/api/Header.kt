package omarbradley.com.gopax.data.remote.api

import omarbradley.com.common.util.*

data class Signature(
    val secret: String,
    val method: HttpMethod,
    val requestPath: String,
    val nonce: Long,
    val body: Any? = null
)

fun Signature.generateSignature(): String {
    val endPoint = requestPath.split("\\?")[0]
    val bodyJson = body?.toJsonString() ?: ""
    val what = "$nonce${method.name}$endPoint$bodyJson"
    val signedSecretKey = secret.signature(MacAlgorithm.HmacSHA512)
    return signedSecretKey.encodeAsString(what.toByteArray())
}

data class Header(
    val apiKey: String,
    val signature: Signature,
    val contentType: String = JSON_CONTENT_TYPE
)

fun Header.createHeaders() =
    mapOf(
        "API-KEY" to apiKey,
        "SIGNATURE" to signature.generateSignature(),
        "NONCE" to signature.nonce.toString(),
        "Content-Type" to contentType
    )

