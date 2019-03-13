package omarbradley.com.bitcointradebot.base

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import omarbradley.com.bitcointradebot.util.observe

abstract class BaseActivity : AppCompatActivity() {

    protected fun <T> LiveData<T>.observe(observer: (T) -> Unit) = observe(this@BaseActivity, observer)

}
