package comboCode


class AppUser(val name: String, val email: String, val phone: String)

class Notification(val title: String, val message: String)

class UserManager {
    val users = mutableListOf<AppUser>()

    fun registerUser(user: AppUser){
        users.add(user)
    }
}

class NotificationService(private val userManager: UserManager) {

    fun sendEmail(user: AppUser, notification: Notification): String {
        return "Email для ${user.name}: ${notification.title} - ${notification.message}"
    }

    fun sendSms(user: AppUser, notification: Notification): String {
        return "SMS для ${user.name}: ${notification.title} - ${notification.message}"
    }

    fun sendPush(user: AppUser, notification: Notification): String {
        return "Push для ${user.name}: ${notification.title} - ${notification.message}"
    }

    fun notifyAll(notification: Notification, channel: String) {

        when (channel) {
            "email" -> {
                for (user in userManager.users) {
                    println(sendEmail(user, notification))
                }
            }
            "sms" -> {
                for (user in userManager.users) {
                    println(sendSms(user, notification))
                }
            }
            "push" -> {
                for (user in userManager.users) {
                    println(sendPush(user, notification))
                }
            }
            else -> println("Неизвестный канал")
        }
    }
}

fun main() {
    val user1 = AppUser("Мария", "jjhfjghj@gmail.com", "86745867867")
    val user2 = AppUser("Виктория", "hghkjhjh@gmail.com", "88678674876")
    val user3 = AppUser("Дмитрий", "fhjfhdvndhg@gmail.com", "86867847586")
    val user4 = AppUser("Арина", "jjhfgjhj2@gmail.com", "8599857684")
    val user5 = AppUser("Василиса", "jhfgjrhgfdld@gmail.com", "85433547267463")

    val userManager = UserManager()
    userManager.registerUser(user1)
    userManager.registerUser(user2)
    userManager.registerUser(user3)
    userManager.registerUser(user4)
    userManager.registerUser(user5)

    val notification = Notification("Добрый день!", "Как ваши дела?")
    val service = NotificationService(userManager)

    service.notifyAll(notification, "email")
    service.notifyAll(notification, "sms")
    service.notifyAll(notification, "push")
}