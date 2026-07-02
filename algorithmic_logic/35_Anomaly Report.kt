package algorithmic_logic

data class Transaction(val id: Int, val amount: Int)

fun main() {
    val input = readln().trim().split(" ").map { it.toInt() }
    val transactions = input.chunked(2).map { Transaction(it[0], it[1]) }

    val anomalies = findAnomalies(transactions)

    println(anomalies)
}

fun findAnomalies(transactions: List<Transaction>): List<Int> {
    val average = transactions.map { it.amount }.average()
    val doorstep = average * 3
    val anomalies = transactions.filter { it.amount > doorstep }
    val sorted = anomalies.sortedByDescending { it.amount }

    return sorted.map { it.id }
}