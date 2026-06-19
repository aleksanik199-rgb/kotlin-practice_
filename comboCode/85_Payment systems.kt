package comboCode

abstract class PaymentSystem(val name: String, val commission: Double) {
    abstract fun pay(amount: Double): String
    abstract fun getBalances(): Double
}

class Card(name: String, commission: Double, var balance: Double) : PaymentSystem(name, commission) {
    override fun pay(amount: Double): String {
        val total = amount + (amount * commission / 100)
        return if (total <= balance) {
            balance -= total
            "Оплачено $amount через $name (комиссия $commission%)"
        } else {
            "Недостаточно средств"
        }
    }
    override fun getBalances(): Double {
        return balance
    }
}

class Wallet(name: String, commission: Double = 0.0, var balance: Double) : PaymentSystem(name, commission) {
    override fun pay(amount: Double): String {
        if (amount <= balance) {
            balance -= amount
            return "Оплачено $amount через $name"
        } else {
            return "Недостаточно средств"
        }
    }
    override fun getBalances(): Double {
        return balance
    }
}

fun main() {
    val payments: List<PaymentSystem> = listOf(
        Card("Visa", 2.0, 50000.0),
        Wallet("Local", 0.0, 80000.0)
    )

    for (payment in payments) {
        println(payment.pay(1000.0))
        println(payment.getBalances())
        println()
    }
}