package omarbradley.com.bitcointradebot

import omarbradley.com.bitcointradebot.gopax.viewmodel.GopaxLoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val appModule: Module = module {

    viewModel {
        GopaxLoginViewModel()
    }

}