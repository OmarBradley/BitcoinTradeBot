package omarbradley.com.bitcointradebot.gopax.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GopaxLoginViewModel : ViewModel() {

    val isVisibleOfStoredAuthKey = MutableLiveData<Boolean>()
    val isVisibleOfAuthKeys = MutableLiveData<Boolean>()

    init {
        isVisibleOfStoredAuthKey.value = false
        isVisibleOfAuthKeys.value = false
    }

}
