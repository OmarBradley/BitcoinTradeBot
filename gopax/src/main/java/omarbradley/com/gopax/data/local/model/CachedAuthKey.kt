package omarbradley.com.gopax.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.joda.time.DateTime

@Entity
data class CachedAuthKey(
    val secretKey: String,
    val apiKey: String,
    val createDateTime: DateTime
) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}
