package algorithmic_logic

fun main() {
    val input = readln().trim().split(" ").map { it.toInt() }
    val orders = input.chunked(2).map { it[0] to it[1] }
    val dayLength =readln().toInt()

    val deliveries = planDeliveries(orders, dayLength)

    println(deliveries)
}

fun planDeliveries(orders: List<Pair<Int, Int>>, dayLength: Int): Int {
    val filterOrders = orders.filter { it.first <= dayLength }
    val sortedOrders = filterOrders.sortedByDescending { it.second.toDouble() / it.first }
    var remainingHours = dayLength
    var totalBonus = 0

    for ((deliveryTime, bonus) in sortedOrders) {
        if (deliveryTime <= remainingHours) {
            remainingHours -= deliveryTime
            totalBonus += bonus
        }
    }
    return totalBonus
}