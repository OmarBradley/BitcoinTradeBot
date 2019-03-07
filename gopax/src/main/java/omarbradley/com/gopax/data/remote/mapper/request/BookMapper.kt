package omarbradley.com.gopax.data.remote.mapper.request

import omarbradley.com.common.domain.Mapper
import omarbradley.com.gopax.data.remote.json.resopnse.BookJson
import omarbradley.com.gopax.entity.resopnse.Book
import omarbradley.com.gopax.entity.resopnse.OrderBook
import omarbradley.com.gopax.entity.resopnse.toList

object BookMapper : Mapper<Book, BookJson> {

    override fun toData(entity: Book): BookJson =
        BookJson(
            entity.bid.map(OrderBook::toList),
            entity.ask.map(OrderBook::toList)
        )

    override fun toEntity(data: BookJson): Book =
        Book(
            data.bid.map(::OrderBook),
            data.ask.map(::OrderBook)
        )

}
