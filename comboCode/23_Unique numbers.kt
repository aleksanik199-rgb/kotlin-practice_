package comboCode

fun main() {
    val numbers = mutableSetOf<Int>()

    while(true){
        print("Введите число (0 для выхода): ")
        val choice = readln().toInt()
        if (choice == 0)break
        numbers.add(choice)
    }
    val sizeNumbers = numbers.size
    val sumNumbers = numbers.sum()

    println("Уникальные числа: ${numbers.joinToString(", ")}")
    println("Количество уникальных чисел: $sizeNumbers")
    println("Сумма уникальных чисел: $sumNumbers")
}