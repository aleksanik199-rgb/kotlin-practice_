package comboCode

abstract class Notifications(val recipient: String, val priority: Int) {
    init {
        require(priority in 1..5) {"Приоритет должен быть от 1 до 5"}
    }

    abstract fun send(): String

    fun describe(): String {
        return "[PRIORITY $priority] ${this::class.simpleName} for $recipient"
    }
}

class EmailNotification(recipient: String, priority: Int, val subject: String): Notifications(recipient, priority) {
    override fun send(): String {
        return "Email sent to $recipient with subject: $subject"
    }
}

class SmsNotification(recipient: String, priority: Int, val phoneNumber: String) : Notifications(recipient, priority) {
    override fun send(): String {
        return "SMS sent to $phoneNumber"
    }
}

fun main() {
    val notifs: List<Notifications> = listOf(
        EmailNotification("Анна", 3, "Ваш баланс пополнен"),
        EmailNotification("Максим", 1, "Подтверждение транзакции"),
        SmsNotification("Александра", 2, "89656569776"),
        SmsNotification("Мария", 4, "7058876536546")
    )

    for (notif in notifs) {
        println(notif.send())
        println(notif.describe())
        println()
    }
}