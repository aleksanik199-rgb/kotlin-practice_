package comboCode

fun main() {
    print("Введите число a: ")
    val a = readln().toDouble()
    print("Введите число b: ")
    val b = readln().toDouble()
    print("Выберите операцию +, -, *, /: ")
    val operation = readln()

    val sum = calculate(a, b, operation)

    println("Ответ: $sum")
}

fun calculate(a: Double, b: Double, operation: String): Double {
    when (operation) {
        "+" -> return a + b
        "-" -> return a - b
        "*" -> return a * b
        "/" -> {
            if (b == 0.0) return 0.0
            return a / b
        }
        else -> return 0.0
    }
}