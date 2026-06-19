package comboCode

fun main() {
    print("Введите число: ")
    val n = readln().toInt()

    val sumEven = sumEvenNumbers(n)
    println("Сумма четных чисел числа $n ($sumEven)")
}

fun sumEvenNumbers(n: Int): Int {
    var sum = 0
    for (i in 1..n){
        if (i % 2 == 0) sum += i
    }
    return sum
}