package comboCode

fun main() {
    val amount = readln().toInt()
    val name = readln()
    val quantity = readln().toInt()
    val promoCode = readln()

    val discountPercent = calculateDiscounts(promoCode)
    val quantitySum = quantity * amount
    val discount = (quantitySum * discountPercent) / 100
    val total = quantitySum - discount

    order(name, amount, quantity, discount, total)
}

fun calculateDiscounts(promoCode: String): Int {
    return if (promoCode == "да") 15 else 0
}

fun order(name: String, amount: Int, quantity: Int, discount: Int, total: Int) {
    println("Заказ: $name")
    println("Сумма: $amount")
    println("Количество: $quantity")
    println("Скидка: $discount")
    println("Итого к оплате: $total")
}