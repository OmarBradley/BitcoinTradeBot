package omarbradley.com.bitcointradebot.main

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import omarbradley.com.bitcointradebot.R
import omarbradley.com.bitcointradebot.base.BaseActivity
import omarbradley.com.bitcointradebot.gopax.GopaxLoginActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_gopax.setOnClickListener {
            startActivity(Intent(this, GopaxLoginActivity::class.java))
            finish()
        }
    }
}
