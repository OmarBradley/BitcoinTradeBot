package omarbradley.com.gopax.data.repository

import omarbradley.com.gopax.entity.resopnse.AuthKey

interface AuthKeyRepository {

    suspend fun getAllAuthKeys(): List<AuthKey>

    suspend fun getAuthKeyByApiKey(apiKey: String): AuthKey

    suspend fun getAuthKeyBySecretKey(secretKey: String): AuthKey

    suspend fun insertAuthKey(authKey: AuthKey)

    suspend fun insertAuthKeys(authKeys: List<AuthKey>)

    suspend fun deleteAuthKey(apiKey: String)

    suspend fun deleteAllAuthKeys()

}
