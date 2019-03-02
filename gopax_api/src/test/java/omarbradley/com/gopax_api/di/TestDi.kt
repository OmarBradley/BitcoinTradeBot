package omarbradley.com.gopax_api.di

import io.kotlintest.TestCase
import io.kotlintest.TestResult
import io.kotlintest.extensions.TestListener
import omarbradley.com.gopax_api.api.GopaxApi
import omarbradley.com.gopax_api.module.gopaxApiModule
import org.koin.core.KoinComponent
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.get

object TestDiListener : KoinComponent, TestListener {

    lateinit var api: GopaxApi

    override fun beforeTest(testCase: TestCase) {
        startKoin { modules(gopaxApiModule) }
        api = get()
    }

    override fun afterTest(testCase: TestCase, result: TestResult) {
        stopKoin()
    }
}
