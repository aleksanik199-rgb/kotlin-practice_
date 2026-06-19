package comboCode

fun main() {
    val name = "Книга"
    val price = 350.0
    val quantity = 4
    val discountPercent = 5

    val priceDiscount = calculateDiscountedPrice(price, discountPercent)
    val total = calculateTotal(priceDiscount, quantity)

    printOrderBook(name, priceDiscount, quantity, total)
}
fun calculateDiscountedPrice(price: Double, discountPercent: Int): Double {
    return price - (price * discountPercent / 100)
}

fun calculateTotal(priceDiscount: Double, quantity: Int): Double {
    return priceDiscount * quantity
}

fun printOrderBook(name: String, priceDiscount: Double, quantity: Int, total: Double) {
    println("Книга: $name")
    println("Цена со скидкой: $priceDiscount")
    println("Количество: $quantity")
    println("Итого: $total")
}
