package omarbradley.com.gopax.entity.resopnse

data class Book(
    val bid: List<OrderBook>,
    val ask: List<OrderBook>
)

data class OrderBook(
    val id: String,
    val price: Int,
    val amount: Double
) {

    constructor(data: List<Any>) : this(
        id = data[0].toString(),
        price = data[1] as Int,
        amount = data[2] as Double
    )

}

fun OrderBook.toList(): List<Any> =
    listOf(id, price, amount)
