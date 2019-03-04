package omarbradley.com.gopax.data.remote.mapper

import omarbradley.com.common.domain.Mapper
import omarbradley.com.gopax.data.remote.json.AssetJson
import omarbradley.com.gopax.entity.Asset

object AssetMapper : Mapper<Asset, AssetJson> {

    override fun mapFromEntity(entity: Asset): AssetJson =
        AssetJson(entity.id, entity.name)

    override fun mapToEntity(data: AssetJson): Asset = Asset(data.id, data.name)

}