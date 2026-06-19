package comboCode

class BankCard(cardNumber: String, balance: Double) {
    var cardNumber: String = cardNumber
        private set

    var balance: Double = balance
        private set
    init  {
        require(cardNumber.length == 16) {"Номер карты должен содержать 16 цифр"}
        require(balance > -1) {"Баланс не может быть отрицательным"}
    }

    var isBlocked: Boolean = false
    private set

    val maskedNumber: String
        get() = "*** **** **** ${cardNumber.takeLast(4)}"

    fun deposit(amount: Double) {
        if (amount > 0 && !isBlocked) {
            balance += amount
        }
    }

    fun block() {
       isBlocked = true
    }

    override fun toString(): String {
        return "Номер карты: $cardNumber, баланс: $balance, блокировка: $isBlocked"
    }
}

fun main(args: Array<String>) {
    val card = BankCard("2373455556436767", 2567799.0)
    val card1 = BankCard("6649567856776875", 6777.0)

    card.deposit(79905.0)
    card.deposit(87878.0)

    card.block()
    card1.block()

    println(card.toString())
    println(card1.toString())
}