package comboCode

fun main() {
    print("Введите сумму заказа: ")
    val price = readln().toDouble()
    print("Введите процент скидки %: ")
    val discount = readln().toDouble()

    val finalDiscount = calculateFinalPrice(price, discount)

    println("Финальная цена: $finalDiscount")
}

fun calculateFinalPrice(price: Double, discount: Double): Double {
    if (discount > 100) {
        return 0.0
    } else if (discount < 0) {
        return price
    } else {
        return price - (price * discount / 100)
    }
}