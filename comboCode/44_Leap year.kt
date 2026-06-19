package comboCode

fun main() {
    print("Введите год: ")
    val year = readln().toInt()

    val leapYear = isLeapYear(year)
    if (leapYear){
        println("Год $year високосный")
    } else {
        println("Год $year невисокосный")
    }
}

fun isLeapYear(year: Int): Boolean{
    return if (year % 400 == 0) true
    else if (year % 100 == 0) false
    else (year % 4 == 0)
}