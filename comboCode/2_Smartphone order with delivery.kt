package comboCode

fun main() {
    val name = "Смартфон"
    val price = 500.0
    val quantity = 3
    val discountPercent = 10

    val priceAfterDiscount = applyDiscount(price, discountPercent)
    val total = finalPrice(priceAfterDiscount, quantity)

    printOrder(name, priceAfterDiscount, quantity, total)
}

fun applyDiscount(price: Double, discountPercent: Int): Double {
    return price - (price * discountPercent / 100)
}

fun finalPrice(priceAfterDiscount: Double, quantity: Int): Double {
    return priceAfterDiscount * quantity
}

fun printOrder(name: String, priceAfterDiscount: Double, quantity: Int, total: Double) {
    println("Заказ: $name")
    println("Цена со скидкой: $priceAfterDiscount")
    println("Количество: $quantity")
    println("Итого: $total")
}
