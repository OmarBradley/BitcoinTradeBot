package omarbradley.com.bitcointradebot.base

import android.app.Application
import androidx.annotation.StringRes
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }

    protected inline fun launch(crossinline block: suspend CoroutineScope.() -> Unit) =
        viewModelScope.launch { block() }

}

abstract class BaseAndroidViewModel(
    application: Application
) : AndroidViewModel(application) {

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }

    protected inline fun launch(crossinline block: suspend CoroutineScope.() -> Unit) =
        viewModelScope.launch { block() }

    protected fun getString(@StringRes resId: Int): String =
        getApplication<Application>().getString(resId)

}
