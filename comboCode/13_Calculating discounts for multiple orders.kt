package comboCode

fun main() {
    val n = readln().toInt()
    var totalWithoutDiscount = 0.0
    var totalDiscount = 0.0

    for (orderNumber in 1..n) {
        print("Заказ №: $orderNumber")
        val amount = readln().toDouble()
        val quantity = readln().toInt()
        val hasDiscount = readln().toBoolean()
        val orderTotal = amount * quantity
        totalWithoutDiscount += orderTotal
        val discount = calculateDiscounts(orderTotal, hasDiscount)
        totalDiscount += discount
    }
    println("Общая стоимость без скидок: $totalWithoutDiscount")
    println("Сумма скидок: $totalDiscount")
    println("Итого к оплате: ${totalWithoutDiscount - totalDiscount}")
}

fun calculateDiscounts(orderTotal: Double, hasDiscount: Boolean): Double {
    return if (hasDiscount) orderTotal * 15 / 100 else 0.0
}