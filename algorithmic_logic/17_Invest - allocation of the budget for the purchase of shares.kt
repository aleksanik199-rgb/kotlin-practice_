package algorithmic_logic

fun main() {
    val input = readln().trim().split(" ").map { it.toInt() }
    val lots = input.chunked(2).map { it[0] to it[1] }
    val budget = readln().toInt()

    val max = maxProfit(lots, budget)

    println(max)
}

fun maxProfit(lots: List<Pair<Int, Int>>, budget: Int): Int {
    val sorted = lots.sortedByDescending { it.second.toDouble() / it.first }
    var remaining = budget
    var totalProfit  = 0

    for (pair in sorted) {
        if (pair.first <= remaining) {
            remaining -= pair.first
            totalProfit += pair.second
        } else {
            break
        }
    }
    return totalProfit
}