package omarbradley.com.gopax.data.remote.mapper.request

import omarbradley.com.common.domain.Mapper
import omarbradley.com.gopax.data.remote.json.resopnse.AssetJson
import omarbradley.com.gopax.entity.AssetType
import omarbradley.com.gopax.entity.resopnse.Asset
import omarbradley.com.gopax.entity.toAsset

object AssetMapper : Mapper<Asset, AssetJson> {

    override fun toData(entity: Asset): AssetJson =
        AssetJson(entity.type.id, entity.type.korName)

    override fun toEntity(data: AssetJson): Asset =
        AssetType.values()
            .first { it.id == data.id }
            .toAsset()

}