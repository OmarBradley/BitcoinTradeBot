package omarbradley.com.gopax.domain.usecase

import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import omarbradley.com.gopax.data.repository.AuthKeyRepository
import omarbradley.com.gopax.entity.resopnse.AuthKey

class ManageAuthKeyUseCase(
    private val authKeyRepository: AuthKeyRepository
) {

    suspend fun getAllAuthKeys(): List<AuthKey> =
        withContext(IO) {
            authKeyRepository.getAllAuthKeys()
        }

    suspend fun deleteAllAuthKeys() =
        withContext(IO) {
            authKeyRepository.deleteAllAuthKeys()
        }

    suspend fun deleteAuthKey(apiKey: String) =
        withContext(IO) {
            authKeyRepository.deleteAuthKey(apiKey)
        }

}
