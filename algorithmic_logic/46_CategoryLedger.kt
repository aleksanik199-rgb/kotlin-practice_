package algorithmic_logic

data class Transact(val category: String, val day: Int, val amount: Int)

fun main() {
    val input = readln().trim().split(" ").toList()
    val transactions = input.chunked(3).map { Transact(it[0], it[1].toInt(), it[2].toInt()) }
    val daysInMonth = readln().toInt()

    val amountSpent = amountSpentByDay(transactions, daysInMonth)

    val readable = amountSpent.mapValues { (_, prefix) -> prefix.contentToString() }
    println(readable)

    println(readable)
}

fun amountSpentByDay(transactions: List<Transact>, daysInMonth: Int): Map<String, LongArray> {
    val byCategory = transactions.groupBy { it.category }

    val prefixByCategory = byCategory.mapValues { (_, categoryTransactions) ->
        val amountByDay = LongArray(daysInMonth + 1)
        for (transaction in categoryTransactions) {
            amountByDay[transaction.day] = amountByDay[transaction.day] + transaction.amount
        }
        val prefix = LongArray(daysInMonth + 1)
        for (i in 1..daysInMonth) {
            prefix[i] = prefix[i - 1] + amountByDay[i]
        }
        prefix
    }
    return prefixByCategory
}