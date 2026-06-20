package algorithmic_logic

import kotlin.math.abs

fun main() {
    val weights = readln().trim().split(" ").map{ it.toInt() }

    val difference = differenceWeight(weights)

    println(difference)
}

fun differenceWeight(weights: List<Int>): Int {
    var maxWeight = 0

    for (i in weights.indices) {
        for (j in weights.indices) {
            val currentWeight = abs(weights[i] - weights[j])
            if (i < j && currentWeight > maxWeight) {
                maxWeight = currentWeight
            }
        }
    }
    return maxWeight
}