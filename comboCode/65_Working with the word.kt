package comboCode

fun main() {
    print("Введите текст: ")
    val text = readln()

    if (text.isEmpty()) return

    val uppercase = text.uppercase()
    val lenght = text.length
    val take = text.take(3)
    val takeLast = text.takeLast(3)
    val reverse = text.reversed()

    println("Заглавными: $uppercase")
    println("Колличество букв: $lenght")
    println("Первые 3 буквы: $take")
    println("Последние 3 буквы: $takeLast")
    println("Перевернутый текст: $reverse")
}