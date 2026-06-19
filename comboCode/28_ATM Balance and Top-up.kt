package comboCode

fun main() {
    var balance = 1000

    while (true) {
        println("1 — Показать баланс")
        println("2 — Пополнить баланс")
        println("3 — Снять деньги")
        println("4 — Выйти")

        val choice = readln().toInt()

        when (choice) {
            1 -> {
                println("Ваш баланс: $balance")
            }
            2 -> {
                print("Введите сумму для пополнения: ")
                val deposit = readln().toInt()
                if (deposit > 0) {
                    balance += deposit
                    println("Баланс пополнен. Текущий баланс: $balance")
                } else {
                    println("Ошибка")
                }
            }
            3 -> {
                print("Введите сумму для снятия: ")
                val withdraw = readln().toInt()
                if (withdraw <= balance) {
                    balance -= withdraw
                    println("Вы сняли $withdraw руб. Текущий баланс: $balance")
                } else {
                    println("Недостаточно средств. Текущий баланс: $balance")
                }
            }
            4 -> {
                println("До свидания!")
                break
            }
            else -> println("Неверный выбор")
        }
    }
}