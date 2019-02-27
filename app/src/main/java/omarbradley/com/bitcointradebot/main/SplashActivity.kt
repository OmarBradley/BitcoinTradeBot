package omarbradley.com.bitcointradebot.main

import android.content.Intent
import android.os.Bundle
import omarbradley.com.bitcointradebot.base.BaseActivity

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

}
