package omarbradley.com.gopax.di

import io.kotlintest.Spec
import io.kotlintest.extensions.TestListener
import omarbradley.com.gopax.data.remote.api.Api
import omarbradley.com.gopax.data.remote.module.gopaxApiModule
import org.koin.core.KoinComponent
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.get

internal object TestDiListener : KoinComponent, TestListener {

    lateinit var api: Api

    override fun beforeSpec(spec: Spec) {
        startKoin { modules(gopaxApiModule) }
        api = get()
    }

    override fun afterSpec(spec: Spec) {
        stopKoin()
    }

}
