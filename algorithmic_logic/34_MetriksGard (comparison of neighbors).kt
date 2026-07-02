package algorithmic_logic

import kotlin.math.abs

fun main() {
    val cpuUsage = readln().trim().split(" ").map { it.toInt() }
    val threshold = readln().toInt()

    val findFirst = findFirstSpike(cpuUsage, threshold)

    println(findFirst)
}

fun findFirstSpike(cpuUsage: List<Int>, threshold: Int): Int {
    for (i in 1 until cpuUsage.size) {
        val diff  = abs(cpuUsage[i] - cpuUsage[i - 1])
        if (diff > threshold) return i
    }
    return -1
}