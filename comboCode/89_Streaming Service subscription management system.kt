package comboCode

abstract class Subscription(val ownerName: String, val monthlyPrice: Double, var isActive: Boolean) {

    abstract fun getDescription(): String

    init {
        require(ownerName.isNotEmpty()) {"Имя не может быть пустым"}
        require(monthlyPrice > 0.0) {"Плата за подписку не может быть 0"}
    }

    fun printStatus() {
        if (isActive) {
            println("Имя владельца: $ownerName, статус подписки: $isActive, описание подписки: ${getDescription()}")
        } else {
            println("Имя владельца: $ownerName, статус подписки: $isActive, подписка неактивна")
        }
    }
}

class BasicSubscription(ownerName: String, isActive: Boolean): Subscription(ownerName, 299.0, isActive) {

    constructor(ownerName: String) : this(ownerName, true)

    override fun getDescription(): String {
        return "Базовая подписка: SD-качество, 1 экран"
    }
}

class PremiumSubscription(ownerName: String, monthlyPrice: Double, isActive: Boolean): Subscription(ownerName, monthlyPrice, isActive) {

    constructor(ownerName: String, monthlyPrice: Double) : this(ownerName, monthlyPrice, true)

    override fun getDescription(): String {
        return "Премиум подписка: 4K-качество, 4 экрана"
    }
}

fun main() {
    val subscriptions : List<Subscription> = listOf(
        BasicSubscription("Алина"),
        BasicSubscription("Максим"),
        BasicSubscription("Вероника"),
        PremiumSubscription("Дмитрий", 500.0),
        PremiumSubscription("Степан", 400.0, false),
        PremiumSubscription("Арина", 600.0)
    )

    for (subscription in subscriptions) {
        subscription.printStatus()
    }

    var total = 0.0
    for (subscription in subscriptions) {
        if (subscription.isActive) {
            total += subscription.monthlyPrice
        }
    }
    println("Ежемесячный доход компании: $total")
}