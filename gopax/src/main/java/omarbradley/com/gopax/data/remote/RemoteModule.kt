package omarbradley.com.gopax.data.remote

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import omarbradley.com.gopax.BuildConfig
import omarbradley.com.gopax.data.remote.api.AuthApi
import omarbradley.com.gopax.data.remote.api.NonAuthApi
import omarbradley.com.gopax.data.repository.AuthRepository
import omarbradley.com.gopax.data.repository.NonAuthRepository
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val API_END_POINT = "https://api.gopax.co.kr"

val goapxRemoteModule = module {

    single { RemoteNonAuthRepository(nonAuthApi) as NonAuthRepository }
    single { RemoteAuthRepository(authApi) as AuthRepository }
}

val retrofit: Retrofit = createNetworkClient(
    API_END_POINT,
    BuildConfig.DEBUG
)
val authApi: AuthApi = retrofit.create(AuthApi::class.java)
val nonAuthApi: NonAuthApi = retrofit.create(NonAuthApi::class.java)

fun createNetworkClient(baseUrl: String, debug: Boolean = false) =
    retrofitClient(baseUrl, httpClient(debug))

private fun httpClient(debug: Boolean): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
    val clientBuilder = OkHttpClient.Builder()
    if (debug) {
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        clientBuilder.addInterceptor(httpLoggingInterceptor)
    }
    return clientBuilder.build()
}

private fun retrofitClient(baseUrl: String, httpClient: OkHttpClient): Retrofit =
    Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
