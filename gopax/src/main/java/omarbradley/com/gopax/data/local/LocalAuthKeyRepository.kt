package omarbradley.com.gopax.data.local

import omarbradley.com.gopax.data.repository.AuthKeyRepository
import omarbradley.com.gopax.data.local.dao.AuthKeyDao
import omarbradley.com.gopax.data.local.mapper.AuthKeyMapper
import omarbradley.com.gopax.entity.resopnse.AuthKey

class LocalAuthKeyRepository(
    private val authKeyDao: AuthKeyDao
) : AuthKeyRepository {

    override suspend fun getAllAuthKeys(): List<AuthKey> =
        authKeyDao.getAllAuthKeys()
            .map(AuthKeyMapper::toEntity)

    override suspend fun getAuthKeyByApiKey(apiKey: String): AuthKey =
        authKeyDao.getAuthKeyByApiKey(apiKey)
            .run { AuthKeyMapper.toEntity(this) }

    override suspend fun getAuthKeyBySecretKey(secretKey: String): AuthKey =
        authKeyDao.getAuthKeyBySecretKey(secretKey)
            .run { AuthKeyMapper.toEntity(this) }

    override suspend fun insertAuthKey(authKey: AuthKey) =
        authKeyDao.insertAuthKey(AuthKeyMapper.toData(authKey))

    override suspend fun insertAuthKeys(authKeys: List<AuthKey>) =
        authKeyDao.insertAuthKeys(authKeys.map(AuthKeyMapper::toData))

    override suspend fun deleteAuthKey(apiKey: String) =
        authKeyDao.deleteAuthKey(apiKey)

    override suspend fun deleteAllAuthKeys() =
        authKeyDao.deleteAllAuthKeys()

}
