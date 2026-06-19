package algorithmic_logic

fun main() {
    val transactions = readln().trim().split(" ").map { it.toInt() }

    val total = calculateBalance(transactions)
    println(total)
}
fun calculateBalance(transactions: List<Int>): Int {
    return transactions.sum()
}