package omarbradley.com.gopax.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import omarbradley.com.gopax.data.local.dao.AuthKeyDao
import omarbradley.com.gopax.data.local.model.CachedAuthKey

@Database(entities = [CachedAuthKey::class], version = 1, exportSchema = false)
@TypeConverters(DateTimeConverter::class)
abstract class GopaxDatabase : RoomDatabase() {

    abstract fun authKeyDao(): AuthKeyDao

}
