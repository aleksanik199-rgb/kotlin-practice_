package algorithmic_logic

fun main() {
    val (freeLimitGb, pricePerGb) = readln().trim().split(" ").map { it.toInt() }
    val monthlyUsageGbs = readln().trim().split(" ").map { it.toInt() }

    val pay = sumCostOverruns(freeLimitGb, pricePerGb, monthlyUsageGbs)

    println(pay)
}

fun sumCostOverruns(freeLimitGb: Int, pricePerGb: Int, monthlyUsageGbs: List<Int>): Int {
    var total = 0
    for (monthlyUsage in monthlyUsageGbs) {
        if (monthlyUsage > freeLimitGb) {
            total += (monthlyUsage - freeLimitGb) * pricePerGb
        }
    }
    return total
}