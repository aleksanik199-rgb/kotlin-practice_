package comboCode

fun main() {
    val invoiceAmount = readln().toInt()
    val tipsPercent = readln().toInt()

    val tips = sumTips(invoiceAmount, tipsPercent)
    val total = sumTotal (invoiceAmount, tips)

    printOrder(invoiceAmount, tips, total)
}

fun sumTips(invoiceAmount: Int, tipsPercent : Int): Int {
    return invoiceAmount * tipsPercent / 100
}

fun sumTotal(invoiceAmount: Int, tips : Int): Int {
    return invoiceAmount + tips
}

fun printOrder(invoiceAmount: Int, tips : Int, total: Int) {
    println("Счёт: $invoiceAmount")
    println("Чаевые: $tips")
    println("Итого: $total")
}
