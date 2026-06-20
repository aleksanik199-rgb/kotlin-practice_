package algorithmic_logic

fun main() {
    val prices = readln().trim().split(" ").map { it.toInt() }
    val targetSum = readln().toInt()

    val index = indexPairs(prices, targetSum)
    println(index)

}

fun indexPairs(prices: List<Int>, targetSum: Int): List<Pair<Int, Int>> {
    val pairs = mutableListOf<Pair<Int, Int>>()
    for (i in prices.indices) {
        for (j in prices.indices) {
            if (i < j && prices[i] + prices[j] == targetSum) {
                pairs.add(Pair(i, j))
            }
        }
    }
    return pairs
}