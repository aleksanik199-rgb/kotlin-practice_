package algorithmic_logic

fun main() {
    val sumPay = readln().trim().split(" ").map { it.toInt() }
    val dailyLimit = readln().toInt()

    val payment = processedPayments(sumPay, dailyLimit)

    println(payment)
}

fun processedPayments(sumPay: List<Int>, dailyLimit: Int): Int {
    val sortedPay = sumPay.sorted()
    var remaining = dailyLimit
    var count = 0

    for (payment in sortedPay) {
        if (payment <= remaining) {
            remaining -= payment
            count++
        } else {
            break
        }
    }
    return count
}
