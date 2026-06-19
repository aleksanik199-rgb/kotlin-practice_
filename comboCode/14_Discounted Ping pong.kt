package comboCode

fun main() {
    var answer: String

    do {
        val price = readln().toDouble()
        val quantity = readln().toInt()
        val hasDiscount = readln().toBoolean()

        val orderTotal = price * quantity
        val discount = calculatesDiscounts(orderTotal, hasDiscount)
        val finalTotal = orderTotal - discount

        println("Сумма заказа: $orderTotal")
        println("Скидка: $discount")
        println("К оплате: $finalTotal")

        println("Хотите продолжить? (да/нет)")
        answer = readln()
    }while (answer == "да")
}

fun calculatesDiscounts(orderTotal: Double, hasDiscount: Boolean): Double {
    return if (hasDiscount) 15 * orderTotal / 100 else 0.0
}