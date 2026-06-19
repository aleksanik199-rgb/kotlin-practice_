package comboCode

class BankAccount(var balance: Double) {

    fun deposit(amount: Double) {
        if (amount > 0) {
            balance += amount
            println("Баланс пополнен")
        } else {
            println("Суммма должна быть положительной!")
        }
    }

    fun withdraw(amount: Double): Boolean {
        return if (amount > 0 && amount <= balance) {
            balance -= amount
            true
        } else {
            false
        }
    }
}

class Atm(val account: BankAccount) {

    fun showMenu(): Int {
        println("1 — Пополнить")
        println("2 — Снять")
        println("3 — Баланс")
        println("4 — Выйти")
        print("Введите выбор: ")
        return readln().toInt()
    }

    fun start() {
        while(true) {
            when (showMenu()) {
                1 -> {
                    print("Введите сумму: ")
                    val sum = readln().toDouble()
                    account.deposit(sum)
                }
                2 -> {
                    print("Введите сумму: ")
                    val sum = readln().toDouble()
                    if (account.withdraw(sum)) {
                        println("Успешно снято $sum")
                    } else {
                        println("Недостаточно средств")
                    }
                }
                3 -> println("Баланс: ${account.balance}")
                4 -> {
                    println("До свидания!")
                    break
                }
                else -> println("Ошибка!")
            }
        }
    }
}

fun main() {
    val account = BankAccount(500.0)
    val atm = Atm(account)

    atm.start()
}