package omarbradley.com.gopax.data.repository

import omarbradley.com.gopax.entity.AssetType
import omarbradley.com.gopax.entity.resopnse.*

interface NonAuthRepository {

    suspend fun getAsserts(): List<Asset>

    suspend fun getTradingPairs(): List<TradingPair>

    suspend fun getTicker(baseAssetType: AssetType, quoteAssetType: AssetType): Ticker

    suspend fun getBook(baseAssetType: AssetType, quoteAssetType: AssetType): Book

    suspend fun getTrades(baseAssetType: AssetType, quoteAssetType: AssetType): List<Trade>

}