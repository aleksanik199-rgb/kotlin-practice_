package comboCode

abstract class InvestmentAccount(val accountId: String, val ownerName: String) {
    protected val _transactions: MutableList<String> = mutableListOf()
    val transactions: List<String> get() = _transactions
    var balance: Double = 5000.0
        protected set(value) {
            val change = value - field
            val sign = if (change >= 0) "+" else "-"
            _transactions.add("[$sign][$change] | Баланс: $value]")
            field = value
        }

    abstract val riskLevel: String
    abstract fun invest(amount: Double)

    override fun toString(): String {
        return "id: $accountId, Имя владельца: $ownerName, Баланс: $balance"
    }
}

class ConservativeAccount(accountId: String, ownerName: String): InvestmentAccount(accountId, ownerName) {
    override val riskLevel: String = "LOW"
    val monthlyYield: Double
        get() = balance * 0.05 / 12
    override fun invest(amount: Double) {
        require(amount > 0) { "Сумма не может быть меьше или равна 0" }
        if (amount <= balance * 0.3) {
            balance -= amount
        }
    }
}

class AggressiveAccount(accountId: String, ownerName: String): InvestmentAccount(accountId, ownerName) {
    override val riskLevel: String = "HIGH"
    override fun invest(amount: Double) {
        require(amount > 0) { "Сумма не может быть меьше или равна 0" }
        if (amount <= balance * 0.9) {
            if (Math.random() < 0.4) {
                balance -= amount
                _transactions.add("[LOSS] Инвестиция сгорела: -$amount")
            } else {
                balance -= amount
            }
        }
    }
}

fun main() {
    val invests: List<InvestmentAccount> = listOf(
        ConservativeAccount("6547h", "hghnhfn"),
        AggressiveAccount("767h", "tghrth"),
    )

    val acc = ConservativeAccount("6547h", "hghnhfn")
    acc.invest(500.0)
    acc.invest(300.0)
    println(acc.transactions)

    for (invest in invests) {
        println(invest)
    }
}