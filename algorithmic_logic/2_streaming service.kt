package algorithmic_logic

fun main() {
    val(watchedMinutes, freeMinutes, basePrice, overageRate, maxOverageCap) = readln().trim().split(" ").map { it.toInt() }

    val pay = actualNumberMinutesViewed(watchedMinutes, freeMinutes, basePrice, overageRate, maxOverageCap)
    println(pay)
}

fun actualNumberMinutesViewed(watchedMinutes: Int, freeMinutes: Int, basePrice: Int, overageRate: Int, maxOverageCap: Int): Int {
    val overage = if (watchedMinutes <= freeMinutes) 0 else (watchedMinutes - freeMinutes)
    val rawOverageCost = overageRate * overage
    val actualOverageCost = minOf(rawOverageCost, maxOverageCap)
    val totalPay = actualOverageCost + basePrice
    return totalPay
}