package omarbradley.com.gopax.data.remote.module

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import omarbradley.com.gopax.data.remote.api.Api
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val GOPAX_API_END_POINT = "https://api.gopax.co.kr"

val gopaxApiModule = module {

    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    single {
        CoroutineCallAdapterFactory()
    }

    single {
        GsonConverterFactory.create()
    }

    single {
        Retrofit.Builder()
            .baseUrl(GOPAX_API_END_POINT)
            .client(get() as OkHttpClient)
            .addCallAdapterFactory(get() as CoroutineCallAdapterFactory)
            .addConverterFactory(get() as GsonConverterFactory)
            .build()
            .create(Api::class.java)
    }

}
