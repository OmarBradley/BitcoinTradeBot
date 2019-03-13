package omarbradley.com.gopax.di

import androidx.room.Room
import androidx.test.InstrumentationRegistry
import omarbradley.com.gopax.data.local.LocalAuthKeyRepository
import omarbradley.com.gopax.data.local.db.GopaxDatabase
import omarbradley.com.gopax.data.repository.AuthKeyRepository
import org.koin.dsl.module

val goapxTestDatabaseModule = module {

    single { LocalAuthKeyRepository(get()) as AuthKeyRepository }

    factory {
        Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getTargetContext(), GopaxDatabase::class.java)
            .build()
    }

    single {
        get<GopaxDatabase>().authKeyDao()
    }

}
