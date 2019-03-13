package omarbradley.com.bitcointradebot.main

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import omarbradley.com.bitcointradebot.R
import omarbradley.com.bitcointradebot.base.BaseActivity
import omarbradley.com.bitcointradebot.gopax.activity.GopaxLoginActivity
import org.jetbrains.anko.startActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_gopax.setOnClickListener {
            startActivity<GopaxLoginActivity>()
        }
    }
}
