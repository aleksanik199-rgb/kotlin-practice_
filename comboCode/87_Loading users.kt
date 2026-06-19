package comboCode

class UserItem(val name: String, val age: Int, val email: String) {
    init {
        if (age < 0 || age > 150) {
            println("Возраст $age некорректен, установлен 18")
        }
    }

    constructor(name: String, age: Int) : this(name, age, "unknown@example.com")

    override fun toString(): String {
        return "Создан пользователь: $name, $age, $email"
    }
}

fun  main() {
    val user1 = UserItem("Мария", 26, "dhhhvghgfh@gmail.com")
    val user2 = UserItem("Борис", 30)

    println(user1)
    println(user2)
}