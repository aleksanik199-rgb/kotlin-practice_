package comboCode

fun main() {
    print("Введите число: ")
    val number = readln().toInt()

    val result = factorial(number)
    if (result == -1) {
        println("Факториал отрицательного числа не определён")
    } else {
        println("Факториал  $number = $result")
    }
}
fun factorial(number: Int): Int {
    if (number < 0) return -1
    if (number == 0) return 1
    var result = 1
    for (i in 1..number) {
        result *= i
    }
    return result
}