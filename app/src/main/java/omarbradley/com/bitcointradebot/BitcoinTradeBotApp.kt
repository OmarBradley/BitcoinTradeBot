package omarbradley.com.bitcointradebot

import android.app.Application
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric
import omarbradley.com.gopax.data.local.gopaxLocalModule
import omarbradley.com.gopax.data.remote.goapxRemoteModule
import omarbradley.com.gopax.domain.gopaxDomainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BitcoinTradeBotApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Fabric.with(this, Crashlytics())
        startKoin {
            androidContext(this@BitcoinTradeBotApp)
            modules(
                appModule,
                gopaxDomainModule,
                gopaxLocalModule,
                goapxRemoteModule
            )
        }
    }

}
