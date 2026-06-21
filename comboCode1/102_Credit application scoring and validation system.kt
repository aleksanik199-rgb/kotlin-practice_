package comboCode1

abstract class CreditApplication(val applicantName: String, requestedAmount: Int) {
    var requestedAmount: Int = requestedAmount
       private set(value) {
           field = if (value < 10000) 10000 else value
       }

    init {
        require(requestedAmount > 0) { "Сумма должна быть положительной"}
    }

    abstract fun calculateRiskScore(): Int
}

class StandardApplication(applicantName: String, requestedAmount: Int) : CreditApplication(applicantName, requestedAmount) {

    constructor(applicantName: String) : this(applicantName, 5000)

    override fun calculateRiskScore(): Int {
        return requestedAmount/ 1000
    }
}

class VipApplication(applicantName: String, requestedAmount: Int, val loyaltyYears: Int) : CreditApplication(applicantName, requestedAmount) {
    override fun calculateRiskScore(): Int {
       val riskScope = maxOf((requestedAmount / 1000) - (loyaltyYears * 5), 0)
        return riskScope
    }
}

fun main() {
    val credits: List<CreditApplication> = listOf(
        StandardApplication("Анна", 1000),
        StandardApplication("Мария"),
        VipApplication("Виктория", 6000000, 5),
        VipApplication("Дмитрий", 3000000, 9)
    )

    val risk = rankByRisk(credits)

    for (credit in credits) {
        println(credit)
        println(credit.calculateRiskScore())
        println()
    }
}

fun rankByRisk(credits: List<CreditApplication>): List<String> {
    return credits.sortedBy { it.calculateRiskScore() }.map { it.applicantName }
}