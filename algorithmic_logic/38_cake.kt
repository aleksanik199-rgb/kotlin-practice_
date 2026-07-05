package algorithmic_logic

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val height = readln().trim().split(" ").map { it.toInt() }

        val max = maxHeigh(n, height)

        println("${max.joinToString(" ")}")
    }
}

fun maxHeigh(n: Int, height: List<Int>): List<Long> {
    val result = mutableListOf<Long>()
    var prefixSum: Long = 0
    var currentAnswer = Long.MAX_VALUE

    for (i in height.indices) {
        prefixSum += height[i].toLong()
        currentAnswer = minOf(currentAnswer, prefixSum / (i + 1))
        result.add(currentAnswer)
    }
    return result
}