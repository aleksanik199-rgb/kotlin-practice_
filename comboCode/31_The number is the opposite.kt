package comboCode

fun main() {
    print("Введите число: ")
    var number = readln().toInt()
    var result = 0

    while (number > 0){
        val digit = number % 10
        result = result * 10 + digit
        number /= 10
    }
    println("Результат: $result")
}