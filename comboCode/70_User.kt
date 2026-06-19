package comboCode

class User(val name: String, val age: Int) {

    fun isAdult(): Boolean = age >= 18

    fun greet(): String {
        return "Привет, меня зовут $name"
    }
}
fun main() {
    val user1 = User("Маша", 25)
    val user2 = User("Костя", 15)

    println(user1.greet())
    println("Совершеннолетний: ${user1.isAdult()}")

    println(user2.greet())
    println("Совершеннолетний: ${user2.isAdult()}")
}
