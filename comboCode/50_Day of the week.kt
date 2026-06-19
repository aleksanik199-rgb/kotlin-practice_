package comboCode

fun main() {
    print("Введите число от 1 до 7: ")
    val dayNumber = readln().toInt()

    val dayWeek = getDayOfWeek(dayNumber)
    println("День недели: $dayWeek")
}

fun getDayOfWeek(dayNumber: Int): String {
    return when (dayNumber) {
        1 -> "Понедельник"
        2 -> "Вторник"
        3 -> "Среда"
        4 -> "Четверг"
        5 -> "Пятница"
        6 -> "Суббота"
        7 -> "Воскресенье"
        else -> "Ошибка ввода"
    }
}