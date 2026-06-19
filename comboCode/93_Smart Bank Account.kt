package comboCode

class BankAccounts(private var balance: Double) {
    val balanceForUser: Double
    get() = balance

    fun withdraw(amount: Double): Boolean {
        return if (amount <= balance) {
            balance -= amount
            true
        } else {
            false
        }
    }

    fun deposit(amount: Double): Boolean {
        return if (amount > 0) {
            balance += amount
            true
        } else {
            false
        }
    }
}

fun main() {
    val bankAccounts = BankAccounts(10000.0)

    if (bankAccounts.withdraw(5000.0)) {
        println("Снятие прошло успешно: баланс ${bankAccounts.balanceForUser}")
    } else {
        println("Недостаточно средств")
    }

    if (bankAccounts.deposit(500.0)) {
        println("Пополнение прошло успешно: баланс ${bankAccounts.balanceForUser}")
    } else {
        println("Ошибка операции")
    }
}