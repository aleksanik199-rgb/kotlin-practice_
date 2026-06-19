package comboCode

fun main() {
    val amount = readln().toInt()
    val name = readln()
    val hasPromo = readln()
    val isExpress = readln()

    val discountPercent = calculateDiscount(hasPromo)
    val discountAmount = amount * discountPercent / 100
    val delivery = calculateDelivery(isExpress)
    val total = amount - discountAmount + delivery

    printOrder(name, amount, discountAmount, delivery, total)
}

fun calculateDiscount(hasPromo: String): Int {
    return if (hasPromo == "да") 15 else 0
}

fun calculateDelivery(isExpress: String): Int {
    return if (isExpress == "да") 500 else 200
}

fun printOrder(name: String, amount: Int, discountAmount: Int, delivery: Int, total: Int) {
    println("Товар: $name")
    println("Сумма заказа: $amount")
    println("Скидка: $discountAmount")
    println("Доставка: $delivery")
    println("Итого к оплате: $total")
}