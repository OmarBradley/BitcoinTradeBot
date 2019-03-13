package omarbradley.com.bitcointradebot

import omarbradley.com.gopax.data.repository.AuthKeyRepository
import omarbradley.com.gopax.entity.resopnse.AuthKey

class TestDummyAuthKeyRepository : AuthKeyRepository {

    private var dummyAuthKeys = generateSequence(1, Int::inc)
        .map { AuthKey("secret_$it", "authKey_$it") }
        .take(100)
        .toMutableList()

    override suspend fun getAllAuthKeys(): List<AuthKey> =
        dummyAuthKeys

    override suspend fun getAuthKeyByApiKey(apiKey: String): AuthKey? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getAuthKeyBySecretKey(secretKey: String): AuthKey? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun insertAuthKey(authKey: AuthKey) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun insertAuthKeys(authKeys: List<AuthKey>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun deleteAuthKey(apiKey: String) {
        dummyAuthKeys.removeAll { it.apiKey == apiKey }
    }

    override suspend fun deleteAllAuthKeys() {
        dummyAuthKeys.removeAll { true }
    }

}