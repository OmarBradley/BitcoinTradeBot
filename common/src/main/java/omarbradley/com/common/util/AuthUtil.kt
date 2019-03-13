package omarbradley.com.common.util

import org.apache.commons.codec.binary.Base64
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

enum class MacAlgorithm {
    HMACSHA512
}

fun String.decodeToBase64(): ByteArray =
    Base64.decodeBase64(this)

fun ByteArray.createSecretKeySpec(macAlgorithm: MacAlgorithm) =
    SecretKeySpec(this, macAlgorithm.name)

fun SecretKeySpec.signature(macAlgorithm: MacAlgorithm): Mac =
    Mac.getInstance(macAlgorithm.name)
        .apply {
            init(this@signature)
        }

fun String.signature(macAlgorithm: MacAlgorithm) =
    decodeToBase64()
        .createSecretKeySpec(macAlgorithm)
        .signature(macAlgorithm)

fun Mac.encodeAsString(byteArray: ByteArray): String =
    Base64.encodeBase64String(doFinal(byteArray))
