package algorithmic_logic

fun main() {
    val prices = readln().trim().split(" ").map { it.toInt() }
    val minPrice = readln().toInt()

    val product = productPrice(prices, minPrice)

    println(product)
}

fun productPrice(prices: List<Int>, minPrice: Int): Int {
    var left = 0
    var right = prices.size - 1
    var result = -1

    while (left <= right) {
        val middle = (left + right) / 2
        if (prices[middle] >= minPrice) {
            result = middle
            right = middle - 1
        } else {
            left = middle + 1
        }
    }
    return result
}