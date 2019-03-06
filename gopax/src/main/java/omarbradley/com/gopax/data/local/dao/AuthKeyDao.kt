package omarbradley.com.gopax.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import omarbradley.com.gopax.data.local.model.CachedAuthKey

@Dao
interface AuthKeyDao {

    @Query("SELECT * FROM CachedAuthKey")
    suspend fun getAllAuthKeys(): List<CachedAuthKey>

    /**
     * todo 파라미터 갯수에 따라 메소드를 하나씩 만드는 것이 매우 비효율적으로 보임 -> 효율적인 방법 찾기
     */
    @Query("SELECT * FROM CachedAuthKey WHERE apiKey = :apiKey LIMIT 1")
    suspend fun getAuthKeyByApiKey(apiKey: String): CachedAuthKey

    @Query("SELECT * FROM CachedAuthKey WHERE secretKey = :secretKey LIMIT 1")
    suspend fun getAuthKeyBySecretKey(secretKey: String): CachedAuthKey

    @Insert
    suspend fun insertAuthKey(authKey: CachedAuthKey)

    @Insert
    suspend fun insertAuthKeys(authKeys: List<CachedAuthKey>)

    @Query("DELETE FROM CachedAuthKey WHERE apiKey = :apiKey")
    suspend fun deleteAuthKey(apiKey: String)

    @Query("DELETE FROM CachedAuthKey")
    suspend fun deleteAllAuthKeys()

}
