package omarbradley.com.gopax.domain.usecase

import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import omarbradley.com.common.domain.LoginState
import omarbradley.com.gopax.data.repository.AuthKeyRepository
import omarbradley.com.gopax.data.repository.AuthRepository
import omarbradley.com.gopax.entity.resopnse.AuthKey
import org.joda.time.DateTime

class AuthKeyLoginUseCase(
    private val authRepository: AuthRepository,
    private val authKeyRepository: AuthKeyRepository
) {

    /**
     * 고팍스에서 authKey 괸련 인증 확인 api를 제공해주지 않음,
     * 따라서 로그인을 시도하려는 authKey의 계좌가 조회되느냐 아님 에러가 나는가로 임시방편적으로 로그인을 했는지 안했는지 판단함
     */
    suspend fun loginUseAuthKey(apiKey: String, secretKey: String): LoginState =
        withContext(IO) {
            try {
                authRepository.getBalances(apiKey, secretKey)
                LoginState.Success
            } catch (e: Throwable) {
                LoginState.Fail(e)
            }
        }

    suspend fun autoStoreAuthKey(apiKey: String, secretKey: String) {
        withContext(IO) {
            if (authKeyRepository.getAuthKeyByApiKey(apiKey) == null) {
                val authKey = AuthKey(apiKey, secretKey, DateTime.now())
                authKeyRepository.insertAuthKey(authKey)
            }
        }
    }

}
