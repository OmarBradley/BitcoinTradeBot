package omarbradley.com.bitcointradebot.gopax.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import omarbradley.com.bitcointradebot.R
import omarbradley.com.bitcointradebot.base.BaseActivity
import omarbradley.com.bitcointradebot.databinding.ActivityGopaxLoginBinding
import omarbradley.com.bitcointradebot.gopax.recyclerview.authkeyitem.AuthKeyItemAdapter
import omarbradley.com.bitcointradebot.gopax.viewmodel.GopaxLoginViewModel
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import org.koin.androidx.viewmodel.ext.viewModel

class GopaxLoginActivity : BaseActivity() {

    private val viewModel: GopaxLoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gopax_login)

        val adapter = AuthKeyItemAdapter(
            onClickDelete = { item ->
                viewModel.onClickDelete(item)
                viewModel.refreshAuthKeyItem()
            },
            onLongClick = { item ->
                viewModel.onLongClick(item)
            }
        )

        with(DataBindingUtil.setContentView<ActivityGopaxLoginBinding>(this, R.layout.activity_gopax_login)) {
            setLifecycleOwner(this@GopaxLoginActivity)
            viewModel = this@GopaxLoginActivity.viewModel
            recyclerViewAuthKeys.adapter = adapter
        }

        with(viewModel) {
            refreshView()
            output.authKeyItems().observe(adapter::submitList)
            output.toastMessageResId().observe { toast(it) }

            router.goGopaxMainActivity().observe {
                startActivity<GopaxMainActivity>()
            }
        }
    }
}
