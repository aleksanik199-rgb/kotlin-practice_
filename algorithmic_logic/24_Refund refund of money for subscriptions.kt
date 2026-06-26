package algorithmic_logic

fun main() {
    val refundAmounts = readln().trim().split(" ").map{ it.toInt() }
    val refundBudget = readln().toInt()

    val process = processRefunds(refundAmounts, refundBudget)

    println(process)
}

fun processRefunds(refundAmounts: List<Int>, refundBudget: Int): Int {
    val sortedAmounts = refundAmounts.sorted()
    var totalBudget = refundBudget
    var count = 0

    for (amount in sortedAmounts) {
        if (amount <= totalBudget) {
            totalBudget -= amount
            count++
        } else {
            break
        }
    }
    return count
}