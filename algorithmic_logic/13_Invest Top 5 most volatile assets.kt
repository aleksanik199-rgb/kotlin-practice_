package algorithmic_logic

fun main() {
    val priceChanges = readln().trim().split(" ").map{ it.toInt() }

    val price = priceChangesToDay(priceChanges)

    print(price)
}

fun priceChangesToDay(priceChanges: List<Int>): List<Int> {
    return priceChanges.sortedDescending().take(5)
}