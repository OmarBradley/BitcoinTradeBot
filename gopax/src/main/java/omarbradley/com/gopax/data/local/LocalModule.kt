package omarbradley.com.gopax.data.local

import androidx.room.Room
import omarbradley.com.gopax.data.local.db.GopaxDatabase
import omarbradley.com.gopax.data.repository.AuthKeyRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val gopaxLocalModule = module {

    single { LocalAuthKeyRepository(get()) as AuthKeyRepository }

    single {
        Room.databaseBuilder(androidApplication(), GopaxDatabase::class.java, "gopax-db")
            .build()
    }

    single {
        get<GopaxDatabase>().authKeyDao()
    }

}
