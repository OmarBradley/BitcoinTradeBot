package omarbradley.com.gopax.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.joda.time.DateTime

@Entity
data class CachedAuthKey(
    @PrimaryKey
    val apiKey: String,
    val secretKey: String,
    val createDateTime: DateTime
)
