package omarbradley.com.gopax.data.remote

import omarbradley.com.gopax.data.NonAuthRepository
import omarbradley.com.gopax.data.remote.api.Api
import omarbradley.com.gopax.data.remote.mapper.request.*
import omarbradley.com.gopax.entity.AssetType
import omarbradley.com.gopax.entity.resopnse.*
import omarbradley.com.gopax.entity.toPair

internal class RemoteNonAuthRepository(
    private val api: Api
) : NonAuthRepository {

    override suspend fun getAsserts(): List<Asset> =
        api.getAssets()
            .await()
            .map(AssetMapper::toEntity)

    override suspend fun getTradingPairs(): List<TradingPair> =
        api.getTradingPairs()
            .await()
            .map(TradingPairMapper::toEntity)

    override suspend fun getTicker(baseAssetType: AssetType, quoteAssetType: AssetType): Ticker =
        api.getTicker(baseAssetType toPair quoteAssetType)
            .await()
            .run { TickerMapper.toEntity(this) }

    override suspend fun getBook(baseAssetType: AssetType, quoteAssetType: AssetType): Book =
        api.getBook(baseAssetType toPair quoteAssetType)
            .await()
            .run { BookMapper.toEntity(this) }

    override suspend fun getTrades(baseAssetType: AssetType, quoteAssetType: AssetType): List<Trade> =
        api.getTrades(baseAssetType toPair quoteAssetType)
            .await()
            .map(TradeMapper::toEntity)

}
