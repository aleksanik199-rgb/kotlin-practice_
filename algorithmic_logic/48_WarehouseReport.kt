package algorithmic_logic

data class Delivery(val category: String, val day: Int, val quantity: Int)

fun main() {
    val input = readln().trim().split(" ").toList()
    val delivery = input.chunked(3).map { Delivery(it[0], it[1].toInt(), it[2].toInt()) }
    val daysInMonth = readln().toInt()

    val quantity = quantityReceivedGoods(delivery, daysInMonth)

    val readable = quantity.mapValues { (_, prefix) -> prefix.contentToString() }

    println(readable)
}

fun quantityReceivedGoods(delivery: List<Delivery>, daysInMonth: Int): Map<String, LongArray> {
    val sumCategory = delivery.groupBy { it.category}
    val prefixByCategory = sumCategory.mapValues { (_, categoryDelivery) ->
        val amountDay = LongArray(daysInMonth + 1)
        for (delivery in categoryDelivery) {
            amountDay[delivery.day] = amountDay[delivery.day] + delivery.quantity
        }

        val prefix = LongArray(daysInMonth + 1)
        for (i in 1..daysInMonth) {
            prefix[i] = prefix[i - 1] + amountDay[i]
        }
        prefix
    }
    return prefixByCategory
}