package comboCode

fun main() {
    val name = "Кофе"
    val price = 250.0
    val quantity = 10
    val discount = 15

    val finalPrice = calculateFinalPrice(price, discount)
    val total = totalCost(finalPrice, quantity)

    printReceipt(name, finalPrice, quantity, total)
}

fun calculateFinalPrice(price: Double, discount: Int): Double {
    return price - (price * discount / 100)
}

fun totalCost(price: Double, quantity: Int): Double {
    return price * quantity
}

fun printReceipt(name: String, finalPrice: Double, quantity: Int, total: Double) {
    println("Товар: $name")
    println("Цена со скидкой: $finalPrice")
    println("Количество: $quantity")
    println("Итого: $total")
}
