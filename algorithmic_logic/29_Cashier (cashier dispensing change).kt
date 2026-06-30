package algorithmic_logic

fun main() {
    val denomination = listOf(100, 50, 10, 5, 2, 1)
    val amount = readln().toInt()

    val minCoins = minCoinsForChange(denomination, amount)

    println(minCoins)
}

fun minCoinsForChange(denomination: List<Int>, amount: Int): Int {
    var remaining = amount
    var count = 0


    for (coin in denomination) {
        if (remaining >= coin) {
            val coinCount = remaining / coin
            count += coinCount
            remaining %= coin
        }
    }

    return count
}