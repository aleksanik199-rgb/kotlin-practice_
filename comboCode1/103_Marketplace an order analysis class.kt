package comboCode1

class OrderAnalytics(val orders: List<Int>) {

    val ordersCount: Int
        get() = orders.size

    val totalRevenue: Int
    get() = orders.sum()

    var largeOrderThreshold: Int = 1000
        set(value) {
            field = if (value < 1000) 1000 else value
        }

    fun hasLargeOrder(): Boolean {
        for (order in orders) {
            if (order > largeOrderThreshold) {
                return true
            }
        }
        return false
    }

    fun countLargeOrders(): Int {
        var count = 0

        for (order in orders) {
            if (order > largeOrderThreshold) {
                count++
            }
        }
        return count
    }

    fun findDuplicateOrderPairs(): List<Pair<Int, Int>> {
        val pairs = mutableListOf<Pair<Int, Int>>()

        for (i in orders.indices) {
            for (j in orders.indices) {
                if (i < j && orders[i] == orders[j]) {
                    pairs.add(Pair(i, j))
                }
            }
        }
        return pairs
    }

    fun getTopThreeOrders(): List<Int> {
        return orders.sortedDescending().take(3)
    }
}

fun main() {
    val orderAnalytics = OrderAnalytics(listOf(1000, 2000, 3000, 4000, 5000, 10000))

    println(orderAnalytics.ordersCount)
    println(orderAnalytics.totalRevenue)
    println(orderAnalytics.hasLargeOrder())
    println(orderAnalytics.countLargeOrders())
    println(orderAnalytics.findDuplicateOrderPairs())
    println(orderAnalytics.getTopThreeOrders())
}

