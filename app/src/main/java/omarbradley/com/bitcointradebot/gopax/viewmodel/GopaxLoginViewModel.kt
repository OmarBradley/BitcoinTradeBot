package omarbradley.com.bitcointradebot.gopax.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import omarbradley.com.bitcointradebot.R
import omarbradley.com.bitcointradebot.base.BaseViewModel
import omarbradley.com.bitcointradebot.gopax.recyclerview.authkeyitem.AuthKeyItem
import omarbradley.com.bitcointradebot.gopax.recyclerview.authkeyitem.toAuthKeyItem
import omarbradley.com.common.domain.LoginState
import omarbradley.com.gopax.domain.usecase.AuthKeyLoginUseCase
import omarbradley.com.gopax.domain.usecase.ManageAuthKeyUseCase
import omarbradley.com.gopax.entity.resopnse.AuthKey

class GopaxLoginViewModel(
    private val manageAuthKeyUseCase: ManageAuthKeyUseCase,
    private val authKeyLoginUseCase: AuthKeyLoginUseCase
) : BaseViewModel() {

    private val isVisibleOfStoredAuthKey = MutableLiveData<Boolean>()
    private val isVisibleOfAuthKeys = MutableLiveData<Boolean>()
    private val authKeyItems = MutableLiveData<List<AuthKeyItem>>()
    private val textOfApiKey = MutableLiveData<String>()
    private val textOfSecretKey = MutableLiveData<String>()
    private val toastMessageResId = MutableLiveData<Int>()
    private val enableLoginGopaxButton = MutableLiveData<Boolean>()

    val output = object : Output {
        override fun isVisibleOfStoredAuthKey(): LiveData<Boolean> = isVisibleOfStoredAuthKey
        override fun isVisibleOfAuthKeys(): LiveData<Boolean> = isVisibleOfAuthKeys
        override fun authKeyItems(): LiveData<List<AuthKeyItem>> = authKeyItems
        override fun textOfApiKey(): LiveData<String> = textOfApiKey
        override fun textOfSecretKey(): LiveData<String> = textOfSecretKey
        override fun toastMessageResId(): LiveData<Int> = toastMessageResId
        override fun enableLoginGopaxButton(): LiveData<Boolean> = enableLoginGopaxButton
    }

    private val goGopaxMainActivity = MutableLiveData<Unit>()

    val router = object : Router {
        override fun goGopaxMainActivity(): LiveData<Unit> = goGopaxMainActivity
    }

    fun onClickDelete(item: AuthKeyItem) {
        launch {
            manageAuthKeyUseCase.deleteAuthKey(item.apiKey)
            authKeyItems.value = manageAuthKeyUseCase.getAllAuthKeys()
                .map(AuthKey::toAuthKeyItem)
        }
    }

    fun refreshView() {
        enableLoginGopaxButton.value = true
        refreshAuthKeyItem()
    }

    fun refreshAuthKeyItem() {
        launch {
            val items = manageAuthKeyUseCase.getAllAuthKeys()
                .map(AuthKey::toAuthKeyItem)
            authKeyItems.value = items
            val isVisible = items.isNotEmpty()
            isVisibleOfStoredAuthKey.value = isVisible
            isVisibleOfAuthKeys.value = isVisible
        }
    }

    fun onLongClick(item: AuthKeyItem) {
        textOfApiKey.value = item.apiKey
        textOfSecretKey.value = item.secretKey
    }

    fun inputApiKey(apiKey: String) {
        textOfApiKey.value = apiKey
    }

    fun inputSecretKey(secretKey: String) {
        textOfSecretKey.value = secretKey
    }

    fun onClickLoginGopaxButton() {
        enableLoginGopaxButton.value = false
        val apiKey = textOfApiKey.value ?: ""
        val secretKey = textOfSecretKey.value ?: ""

        launch {
            val loginState = authKeyLoginUseCase.loginUseAuthKey(apiKey, secretKey)
            when (loginState) {
                is LoginState.Success ->
                    try {
                        authKeyLoginUseCase.autoStoreAuthKey(apiKey, secretKey)
                        enableLoginGopaxButton.value = true
                        goGopaxMainActivity.value = Unit
                    } catch (e: Throwable) {
                        toastMessageResId.value = R.string.label_fail_auth_key_auto_store
                        enableLoginGopaxButton.value = true
                    }
                is LoginState.Fail -> {
                    toastMessageResId.value = R.string.label_fail_login
                    enableLoginGopaxButton.value = true
                }
            }
        }
    }

    interface Output {
        fun isVisibleOfStoredAuthKey(): LiveData<Boolean>
        fun isVisibleOfAuthKeys(): LiveData<Boolean>
        fun authKeyItems(): LiveData<List<AuthKeyItem>>
        fun textOfApiKey(): LiveData<String>
        fun textOfSecretKey(): LiveData<String>
        fun toastMessageResId(): LiveData<Int>
        fun enableLoginGopaxButton(): LiveData<Boolean>
    }

    interface Router {
        fun goGopaxMainActivity(): LiveData<Unit>
    }

}
