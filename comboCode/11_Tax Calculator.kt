package comboCode

fun main() {
    val typeIncome = readln()
    val amountIncome = readln().toInt()

    val rate = rateTypeIncome(typeIncome)
    val sumTax = amountIncome * rate / 100
    val total = amountIncome - sumTax

    printOrder(amountIncome, typeIncome, sumTax, rate, total)
}

fun rateTypeIncome(typeIncome: String): Int {
    return when (typeIncome) {
        "salary" -> 13
        "freelance" -> 20
        "investment" -> 15
        else -> 0
    }
}

fun printOrder(amount: Int, typeIncome: String, sumTax: Int, rate: Int, total: Int) {
    println("Доход: $amount")
    println("Тип: $typeIncome")
    println("Налог ($rate%): $sumTax")
    println("Итого: $total")
}
