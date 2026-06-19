package comboCode

fun main() {
    println("1 — Сложить")
    println("2 — Вычесть")
    println("3 — Умножить")
    println("4 — Разделить")
    print("Введите: ")

    val choice = readln().toInt()
    val a = readln().toInt()
    val b = readln().toInt()

    when (choice) {
        1 -> println(a + b)
        2 ->  println(a - b)
        3 ->  println(a * b)
        4 -> if (b != 0) println(a / b) else println("Ошибка")
        else -> println("Нет такой операции")
    }
}