package omarbradley.com.gopax.data.remote.header

import omarbradley.com.common.util.*

internal data class Signature(
    val secret: String,
    val method: HttpMethod,
    val requestPath: String,
    val nonce: Long,
    val body: Any? = null
)

internal fun Signature.generateSignature(): String {
    val endPoint = requestPath.split("\\?")[0]
    val bodyJson = body?.toJsonString() ?: ""
    val what = "$nonce${method.name}$endPoint$bodyJson"
    val signedSecretKey = secret.signature(MacAlgorithm.HMACSHA512)
    return signedSecretKey.encodeAsString(what.toByteArray())
}

internal data class Header(
    val apiKey: String,
    val signature: Signature,
    val contentType: String = JSON_CONTENT_TYPE
)

internal fun Header.createHeaders() =
    mapOf(
        "API-KEY" to apiKey,
        "SIGNATURE" to signature.generateSignature(),
        "NONCE" to signature.nonce.toString(),
        "Content-Type" to contentType
    )

internal fun createHeaders(
    secretKey: String,
    apiKey: String,
    method: HttpMethod,
    requestPath: String,
    nonce: Long = timeSecond,
    body: Any? = null
) =
    Header(
        apiKey,
        Signature(secretKey, method, requestPath, nonce, body)
    ).createHeaders()





