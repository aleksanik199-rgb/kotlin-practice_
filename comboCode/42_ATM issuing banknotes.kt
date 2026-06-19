package comboCode

fun main() {
    print("Введите сумму для выдачи: ")
    val amountIssued = readln().toInt()
    val coupons = listOf(5000, 2000, 1000, 500, 200, 100)
    var remainder = amountIssued

    if (amountIssued !in 100..100000){
        println("Ошибка: сумма должна быть до 100000!")
        return
    }
    if (amountIssued % 100 != 0){
        println("Ошибка: сумма должна быть кратна 100!")
        return
    }

    for (nominal in coupons) {
        val count = remainder / nominal
        if(count > 0){
            println("$nominal: $count")
        }
        remainder = remainder % nominal
    }
}