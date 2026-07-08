package algorithmic_logic

fun main() {
    val dailySpending = readln().trim().split(" ").map { it.toLong() }
    val (l, r) = readln().trim().split(" ").map { it.toInt() }

    val range = rangeSpending(dailySpending, l, r)

    println(range)
}

fun rangeSpending(dailySpending: List<Long>, l: Int, r: Int): Long {
    require(l <= r) { "l не может быть больше r" }
    require(l >= 0 && r < dailySpending.size) {"l и r должны быть в границах массива"}

    val n = dailySpending.size
    val prefix = LongArray(n + 1)

    for (i in 1..n) {
        prefix[i] = prefix[i -1] + dailySpending[i - 1]
    }
    val sum = prefix[r + 1] - prefix[l]
    
    return sum
}