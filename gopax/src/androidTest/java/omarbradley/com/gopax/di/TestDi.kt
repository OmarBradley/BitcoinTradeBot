package omarbradley.com.gopax.di

import androidx.room.Room
import androidx.test.InstrumentationRegistry
import omarbradley.com.gopax.data.AuthKeyRepository
import omarbradley.com.gopax.data.local.LocalAuthKeyRepository
import omarbradley.com.gopax.data.local.db.GopaxDatabase
import org.koin.dsl.module

val goapxTestDatabaseModule = module {

    single { LocalAuthKeyRepository(get()) as AuthKeyRepository }

    single {
        Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getTargetContext(), GopaxDatabase::class.java)
            .allowMainThreadQueries()
            .build()
    }

    single {
        get<GopaxDatabase>().authKeyDao()
    }

}
