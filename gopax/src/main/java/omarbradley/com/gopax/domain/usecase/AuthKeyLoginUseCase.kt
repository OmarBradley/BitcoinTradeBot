package omarbradley.com.gopax.domain.usecase

import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import omarbradley.com.common.domain.LoginState
import omarbradley.com.gopax.data.repository.AuthRepository

class AuthKeyLoginUseCase(
    private val authRepository: AuthRepository
) {

    /**
     * 고팍스에서 authKey 괸련 인증 확인 api를 제공해주지 않음,
     * 따라서 로그인을 시도하려는 authKey의 계좌가 조회되느냐 아님 에러가 나는가로 임시방편적으로 로그인을 했는지 안했는지 판단함
     */
    suspend fun loginUseAuthKey(): LoginState =
        withContext(IO) {
            try {
                authRepository.getBalances()
                LoginState.Success
            } catch (e: Throwable) {
                LoginState.Fail(e)
            }
        }
}
