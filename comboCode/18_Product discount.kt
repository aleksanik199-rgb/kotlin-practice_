package comboCode

fun main() {
    val nameProduct = readln()
    val price = readln().toDouble()
    val quantity = readln().toInt()
    val hasDiscount = readln().toBoolean()

    val sumPay  = price * quantity
    val discount = calculateDiscount(sumPay, hasDiscount)
    val total = sumPay - discount

    println("Товар: $nameProduct")
    println("Итог: $total")
}

fun calculateDiscount(sumPay: Double, hasDiscount: Boolean): Double {
    return if (hasDiscount) sumPay * 10 / 100 else 0.0
}