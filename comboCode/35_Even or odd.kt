package comboCode

fun main() {
    print("Введите число: ")
    val number = readln().toInt()

    val chek = checkEvenOdd(number)

    println("Число $number $chek")
}
fun checkEvenOdd(number: Int): String {
    return when {
        number % 2 == 0 -> "Четное"
        else -> "Нечетное"
    }
}