package omarbradley.com.gopax.data.local.mapper

import omarbradley.com.common.data.Mapper
import omarbradley.com.gopax.data.local.model.CachedAuthKey
import omarbradley.com.gopax.entity.resopnse.AuthKey

object AuthKeyMapper : Mapper<AuthKey, CachedAuthKey> {

    override fun toData(entity: AuthKey): CachedAuthKey =
        CachedAuthKey(entity.secretKey, entity.apiKey, entity.createDateTime)

    override fun toEntity(data: CachedAuthKey): AuthKey =
        AuthKey(data.secretKey, data.apiKey, data.createDateTime)

}
