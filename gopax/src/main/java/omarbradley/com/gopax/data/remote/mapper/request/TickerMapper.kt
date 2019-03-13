package omarbradley.com.gopax.data.remote.mapper.request

import omarbradley.com.common.data.Mapper
import omarbradley.com.common.util.toDateTime
import omarbradley.com.gopax.data.remote.json.resopnse.TickerJson
import omarbradley.com.gopax.entity.resopnse.Ticker

object TickerMapper : Mapper<Ticker, TickerJson> {

    override fun toData(entity: Ticker): TickerJson =
        TickerJson(
            entity.price,
            entity.ask,
            entity.bid,
            entity.volume,
            entity.time.toString()
        )

    override fun toEntity(data: TickerJson): Ticker =
        Ticker(
            data.price,
            data.ask,
            data.bid,
            data.volume,
            data.time.toDateTime()
        )
}