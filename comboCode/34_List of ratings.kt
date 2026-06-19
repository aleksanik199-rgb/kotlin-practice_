package comboCode

fun main() {
    val numbers = mutableListOf<Int>()

    while (true) {
        print("Введите оценку: ")
        val input = readln().toInt()
        if (input == 0)break
        numbers += input
    }
    if (numbers.isEmpty()) {
        println("Оценки не были введены")
        return
    }

    println("Оценки: ${numbers.joinToString(", ")}")
    println("Количество: ${numbers.size}")
    println("Средняя: ${numbers.average()}")
    println("Максимальная: ${numbers.maxOrNull()}")
}