package comboCode

fun main() {
    print("Введите число: ")
    val number = readln().toInt()

    val even = isEven(number)
    if (even) {
        println("Число $number четное")
    }else{
        println("Число $number нечетное")
    }
}

fun isEven(number: Int): Boolean{
    return number % 2 == 0
}