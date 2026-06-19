package comboCode

import kotlin.math.min

abstract class Payment(val amount: Double, val currency: String) {
    abstract fun processPayment(): Boolean
    abstract fun getFee(): Double
    abstract fun info(): String

    fun getAmountWithFee(): Double {
        return amount + getFee()
    }
}

class CardPayment(amount: Double, currency: String, val cardNumber: String, val cvv: String) : Payment(amount, currency) {
    override fun processPayment(): Boolean = cardNumber.startsWith("4") || cardNumber.startsWith("5")
    override fun getFee(): Double {
        val fee = (amount * 1.5) / 100
        return fee.coerceAtLeast(50.0)
    }
    override fun info(): String = "Банковская карта"
}

class DigitalWalletPayment(amount: Double, currency: String, val walletId: String?) : Payment(amount, currency) {
    override fun processPayment(): Boolean = !walletId.isNullOrBlank()
    override fun getFee(): Double = (amount * 0.8) / 100
    override fun info(): String = "Виртуальный кошелек"
}

class CryptoPayment(amount: Double, currency: String, val walletAddress: String) : Payment(amount, currency) {
    override fun processPayment(): Boolean = walletAddress.startsWith("0x") || walletAddress.startsWith("1")
    override fun getFee(): Double {
        val fee = (amount * 2) / 100
        return fee.coerceAtLeast(100.0)
    }
    override fun info(): String = "Криптокошелек"
}

fun main() {
    val payments: List<Payment> = listOf(
        CardPayment(2000.0, "рубль", "647839773467", "8776"),
        DigitalWalletPayment(500000.0, "евро", "8576678uh"),
        CryptoPayment(8000000.0, "доллар", "6478397734868576fghmkrfhg67" )
    )

    for (payment in payments) {
        println(payment.info())
        println("Платёж успешен: ${payment.processPayment()}")
        println(payment.getAmountWithFee())
        println(payment.getFee())
        println()
    }
}