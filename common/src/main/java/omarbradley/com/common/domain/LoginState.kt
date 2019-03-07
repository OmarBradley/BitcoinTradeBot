package omarbradley.com.common.domain

sealed class LoginState {

    object Success : LoginState()

    data class Fail(
        val error: Throwable
    ) : LoginState()

}
