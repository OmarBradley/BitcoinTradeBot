package omarbradley.com.gopax_api.module

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import omarbradley.com.gopax_api.api.GopaxApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val GOPAX_API_END_POINT = "https://api.gopax.co.kr"

val gopaxApiModule = module {

    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor())
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(GOPAX_API_END_POINT)
            .client(get() as OkHttpClient)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GopaxApi::class.java)
    }
}






