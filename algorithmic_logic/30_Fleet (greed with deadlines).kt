package algorithmic_logic

data class Order(val duration: Int, val deadline: Int)

fun main() {
    val input = readln().trim().split(" ").map { it.toInt() }
    val orders = input.chunked(2).map { Order(it[0], it[1]) }

    val maxDelivered = maxDeliveredOrders(orders)

    println(maxDelivered)
}

fun maxDeliveredOrders(orders: List<Order>): Int {
    val sorted = orders.sortedBy { it.deadline }
    var currentTime = 0
    var count = 0

    for (order in sorted) {
        if (currentTime + order.duration <= order.deadline) {
            currentTime += order.duration
            count++
        }
    }
    return count
}