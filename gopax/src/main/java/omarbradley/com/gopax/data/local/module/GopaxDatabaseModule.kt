package omarbradley.com.gopax.data.local.module

import androidx.room.Room
import omarbradley.com.gopax.data.local.db.GopaxDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val gopaxDatabaseModule = module {

    single {
        Room.databaseBuilder(androidApplication(), GopaxDatabase::class.java, "gopax-db")
            .build()
    }

}
