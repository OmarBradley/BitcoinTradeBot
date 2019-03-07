package omarbradley.com.bitcointradebot.gopax.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import omarbradley.com.bitcointradebot.R
import omarbradley.com.bitcointradebot.base.BaseActivity
import omarbradley.com.bitcointradebot.databinding.ActivityGopaxLoginBinding
import omarbradley.com.bitcointradebot.gopax.viewmodel.GopaxLoginViewModel
import org.koin.androidx.viewmodel.ext.viewModel

class GopaxLoginActivity : BaseActivity() {

    private val model: GopaxLoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gopax_login)

        val binding = DataBindingUtil.setContentView<ActivityGopaxLoginBinding>(this, R.layout.activity_gopax_login)
        binding.setLifecycleOwner(this)
        binding.viewModel = model





    }
}
