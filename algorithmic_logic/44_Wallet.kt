package algorithmic_logic

fun main() {
    val charges = readln().trim().split(" ").map { it.toInt() }
    val targetSum = readln().toInt()

    val boolean = pairWithRequiredAmount(charges,targetSum)

    println(boolean)
}

fun pairWithRequiredAmount(charges: List<Int>, targetSum: Int): Boolean {
    val seen = mutableSetOf<Int>()

    for (x in charges) {
        val complement = targetSum - x
        if (complement in seen) {
            return true
        }
        seen.add(x)
    }
    return false
}