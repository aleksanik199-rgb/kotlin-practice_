package comboCode

class Survey(val name: String, val city: String, val age: Int) {
    fun info(): String {
        return "$name из $city, возраст $age"
    }
}

fun main() {
    print("Введите имя: ")
    val name = readln()

    print("Введите город: ")
    val city = readln()

    print("Введите возраст: ")
    val age = readln().toInt()

    var survey = Survey(name, city, age)
    println(survey.info())
}