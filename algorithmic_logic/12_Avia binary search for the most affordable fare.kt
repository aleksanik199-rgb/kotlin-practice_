package algorithmic_logic

fun main() {
    val prices = readln().trim().split(" ").map{ it.toInt() }
    val maxBudget = readln().toInt()

    val ticket = sortingTicketsByAmount(prices, maxBudget)

    println(ticket)
}

fun sortingTicketsByAmount(prices: List<Int>, maxBudget: Int): Int {
    var left = 0
    var right = prices.size - 1
    var result = -1

    while (left <= right) {
        val middle = (left + right) / 2
        if (prices[middle] <= maxBudget) {
            result = middle
            left = middle + 1
        } else {
            right = middle - 1
        }
    }
    return result
}