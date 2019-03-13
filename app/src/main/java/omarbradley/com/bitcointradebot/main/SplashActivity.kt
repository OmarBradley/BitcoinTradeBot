package omarbradley.com.bitcointradebot.main

import android.os.Bundle
import omarbradley.com.bitcointradebot.base.BaseActivity
import org.jetbrains.anko.startActivity

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startActivity<MainActivity>()
        finish()
    }

}
