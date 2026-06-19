package comboCode

class UserProfile {
    var age: Int = 0
        set(value) {
            if (value < 0 || value > 120) {
                println("Ошибка")
            } else {
                field = value
            }
        }
}

fun main() {
    val userProfile = UserProfile()
    userProfile.age = 32
    println(userProfile.age)
}