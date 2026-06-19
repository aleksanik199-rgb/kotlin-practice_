package comboCode

fun main() {
    val number = (1..100).random()
    var attempts = 0


    while (true){
        print("Введи число: ")
        val input = readln().toInt()
        attempts++
        if (input < number) {
            println("Больше")
        } else if (input > number) {
            println("Меньше")
        } else if (input == number) {
            println("Поздравляю!")
            break
        }
    }
    println("Поздравляю! Угадал за $attempts попыток.")
}