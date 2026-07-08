package algorithmic_logic

data class Transactions(val day: Int, val amount: Long)
data class RangeQuery(val l: Int, val r: Int)

fun main() {
    val input = readln().trim().split(" ").map { it.toLong() }
    val transactions = input.chunked(2).map { Transactions(it[0].toInt(), it[1]) }
    val daysInMonth = readln().toInt()
    val suspiciousLimit = readln().toLong()
    val input1 = readln().trim().split(" ").map { it.toInt() }
    val query = input1.chunked(2).map { RangeQuery(it[0], it[1]) }

    val cardHistory = processCardHistory(transactions, daysInMonth, suspiciousLimit, query)

    println(cardHistory)
}

fun processCardHistory(transactions: List<Transactions>, daysInMonth: Int, suspiciousLimit: Long, query: List<RangeQuery>): List<Long>? {
    val dailySums = LongArray(daysInMonth + 2)
    val prefix = LongArray(daysInMonth + 2)
    val result = mutableListOf<Long>()

    for (transaction in transactions) {
        if (transaction.amount > suspiciousLimit) return null
    }

    for (transaction in transactions) {
        dailySums[transaction.day] += transaction.amount
    }

    for (i in 1..daysInMonth + 1) {
        prefix[i] = prefix[i - 1] + dailySums[i - 1]
    }

    for (q in query) {
        result.add(prefix[q.r + 1] - prefix[q.l])
    }
    return result
}