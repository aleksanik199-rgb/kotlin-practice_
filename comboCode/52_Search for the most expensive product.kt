package comboCode

fun main() {
    val products = mapOf("Кофе" to 250.0, "Чай" to 180.0, "Пирог" to 350.0, "Печенье" to 120.0)

    val expensivePrice = findMostExpensivePrice(products)

    println("Самая дорогая цена: $expensivePrice")
}

fun findMostExpensivePrice(products: Map<String, Double>): Double {
    if (products.isEmpty()) return Double.MIN_VALUE

    var maxPrice = Double.MIN_VALUE

    for ((name, price) in products) {
        if (price > maxPrice) {
            maxPrice = price
        }
    }
    return maxPrice
}