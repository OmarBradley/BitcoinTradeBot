package omarbradley.com.gopax.domain

import androidx.test.runner.AndroidJUnit4
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.throws
import omarbradley.com.gopax.data.remote.goapxRemoteModule
import omarbradley.com.gopax.data.repository.AuthRepository
import omarbradley.com.gopax.di.goapxTestDatabaseModule
import omarbradley.com.gopax.domain.usecase.AuthKeyLoginUseCase
import omarbradley.com.gopax.domain.usecase.ManageAuthKeyUseCase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.startKoin
import org.koin.test.KoinTest
import org.koin.test.inject

@RunWith(AndroidJUnit4::class)
class DomainDiTest : KoinTest {

    val apiKey = "1111"
    val secretKey = "22222"

    val manageAuthKeyUseCase: ManageAuthKeyUseCase by inject()
    val remoteAuthRepository: AuthRepository by inject()
    val authKeyLoginUseCase: AuthKeyLoginUseCase by inject()

    @Before
    fun before() {
        startKoin { modules(gopaxDomainModule, goapxTestDatabaseModule, goapxRemoteModule) }
    }

    @Test
    fun `authKeyLoginUseCase_의_DI_가_제대로_설정됬는지`() {
        authKeyLoginUseCase
        assertThat({ authKeyLoginUseCase }, throws<Exception>().not())
    }

}
