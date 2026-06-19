package comboCode

fun main() {
    val number = (1 .. 10).random()
    var attempts = 0
    var input: Int

    do {
        print("Введите число: ")
        input = readln().toInt()
        attempts++
        if (input < number) {
            println("Мороз")
        } else if (input > number) {
            println("Жара")
        } else if (input == number) {
            println("Поздравляю!")
            break
        }
    } while (input != number)
    println("Ты угадал число $number за $attempts попыток")
}