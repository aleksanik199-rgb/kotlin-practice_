package algorithmic_logic

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (n, k) = readln().trim().split(" ").map { it.toInt() }

        val max = maxPossibleNumber(n, k)

        println(max)
    }
}

fun maxPossibleNumber(n: Int, k: Int): Int {
    var remainingBudget = n
    var price = 1
    var totalBits = 0

    while (price.toLong() * k <= remainingBudget) {
        if (price * k <= remainingBudget) {
            remainingBudget -= price * k
            price *= 2
            totalBits += k
        }
    }
    totalBits += remainingBudget / price

    return totalBits
}