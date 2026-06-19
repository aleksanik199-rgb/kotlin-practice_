package comboCode

fun main() {
    print("Введите число: ")
    val n = readln().toInt()

    val numbers = sumNumbers(n)
    println("Сумма чисел от 1 до $n ($numbers)")
}

fun sumNumbers(n: Int): Int {
    var sum = 0
    for (i in 1..n){
        sum += i
    }
    return sum
}