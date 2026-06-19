package comboCode

fun main() {
    val numbers = mutableListOf<Int>()

    while (true) {
        print("Введите число (0 для выхода): ")
        val choice = readln().toInt()
        if (choice == 0) break
        numbers.add(choice)
    }

    val evenNumbers = numbers.filter { it % 2 == 0 }
    val oddNumbers = numbers.filter { it % 2 != 0 }
    val maxNumbers = numbers.maxOrNull()

    println("Все числа: ${numbers.joinToString(", ")}")
    println("Чётные числа: ${evenNumbers.joinToString(", ")}")
    println("Нечётные чисела: ${oddNumbers.joinToString(", ")}")
    println("Максимальное число: $maxNumbers")
}