package algorithmic_logic

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val a = readln().trim().split(" ").map { it.toInt() }

        val totalSum = totalSumTowers(n, a)

        println(totalSum)
    }
}

fun totalSumTowers(n: Int, a: List<Int>): Int {
    var currentMin = a[0]
    var totalHeight = 0

    for (i in a.indices) {
        currentMin = minOf(currentMin, a[i])
        totalHeight += currentMin

    }
    return totalHeight
}