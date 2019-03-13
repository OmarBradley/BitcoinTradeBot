package omarbradley.com.gopax.entity.resopnse

import org.joda.time.DateTime

data class AuthKey(
    val secretKey: String,
    val apiKey: String,
    val createDateTime: DateTime
) {

    constructor(secretKey: String, apiKey: String) : this(
        secretKey = secretKey,
        apiKey = apiKey,
        createDateTime = DateTime.now()
    )
}
