package omarbradley.com.gopax.local

import androidx.test.runner.AndroidJUnit4
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import kotlinx.coroutines.runBlocking
import omarbradley.com.gopax.data.repository.AuthKeyRepository
import omarbradley.com.gopax.di.goapxTestDatabaseModule
import omarbradley.com.gopax.entity.resopnse.AuthKey
import org.joda.time.DateTime
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject

@RunWith(AndroidJUnit4::class)
class GopaxDatabaseTest : KoinTest {

    private val authKeyRepository: AuthKeyRepository by inject()

    private val dummyAuthKeys = listOf(
        AuthKey("secretKey_1", "apiKey_1", DateTime(2019, 1, 1, 9, 0, 0)),
        AuthKey("secretKey_2", "apiKey_2", DateTime(2019, 2, 1, 9, 0, 0)),
        AuthKey("secretKey_3", "apiKey_3", DateTime(2019, 3, 1, 9, 0, 0))
    )

    @Before
    fun before() {
        startKoin { modules(goapxTestDatabaseModule) }
        runBlocking {
            authKeyRepository.insertAuthKeys(dummyAuthKeys)
        }
    }

    @Test
    fun getAllAuthKeysTest() {
        runBlocking {
            val allAuthKeys = authKeyRepository.getAllAuthKeys()
            assertThat(allAuthKeys.size, equalTo(dummyAuthKeys.size))
        }
    }

    @Test
    fun getAuthKeyByApiKeyTest() {
        runBlocking {
            val exampleApiKey = "apiKey_1"
            val secretKey = authKeyRepository.getAuthKeyByApiKey(exampleApiKey).secretKey
            assertThat(secretKey, equalTo("secretKey_1"))
        }
    }

    @Test
    fun getAuthKeyBySecretKeyTest() {
        runBlocking {
            val exampleSecretKey = "secretKey_1"
            val apiKey = authKeyRepository.getAuthKeyBySecretKey(exampleSecretKey).apiKey
            assertThat(apiKey, equalTo("apiKey_1"))
        }
    }

    @Test
    fun insertAuthKeyTest() {
        runBlocking {
            val exampleAuthKey = AuthKey("secretKey_3", "apiKey_3", DateTime(2019, 3, 1, 9, 0, 0))
            authKeyRepository.insertAuthKey(exampleAuthKey)

            val totalSize = authKeyRepository.getAllAuthKeys().size
            assertThat(4, equalTo(totalSize))
        }
    }

    @Test
    fun deleteAuthKeyTest() {
        runBlocking {
            val deleteApiKey = "apiKey_3"
            authKeyRepository.deleteAuthKey(deleteApiKey)
            val totalSize = authKeyRepository.getAllAuthKeys().size
            assertThat(2, equalTo(totalSize))
        }
    }

    @After
    fun after() {
        runBlocking {
            authKeyRepository.deleteAllAuthKeys()
        }
        stopKoin()
    }

}