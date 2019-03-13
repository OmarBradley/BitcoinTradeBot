package omarbradley.com.gopax.data.local.db

import androidx.room.TypeConverter
import org.joda.time.DateTime

class DateTimeConverter {

    @TypeConverter
    fun toDateTime(milliseconds: Long) =
        DateTime(milliseconds)

    @TypeConverter
    fun toLong(dateTime: DateTime) =
        dateTime.millis

}