package omarbradley.com.gopax.data.module

import omarbradley.com.gopax.data.local.LocalAuthKeyRepository
import omarbradley.com.gopax.data.remote.RemoteAuthRepository
import omarbradley.com.gopax.data.remote.RemoteNonAuthRepository
import omarbradley.com.gopax.data.remote.module.authApi
import omarbradley.com.gopax.data.remote.module.nonAuthApi
import omarbradley.com.gopax.data.repository.AuthKeyRepository
import omarbradley.com.gopax.data.repository.AuthRepository
import omarbradley.com.gopax.data.repository.NonAuthRepository
import org.koin.dsl.module

val gopaxDataModule = module {

    single { (apiKey: String, secretKey: String) ->
        RemoteAuthRepository(
            authApi,
            apiKey,
            secretKey
        ) as AuthRepository
    }
    single { RemoteNonAuthRepository(nonAuthApi) as NonAuthRepository }
    single { LocalAuthKeyRepository(get()) as AuthKeyRepository }
}
