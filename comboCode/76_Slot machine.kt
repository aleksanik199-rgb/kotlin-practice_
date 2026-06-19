package comboCode

import kotlin.random.Random

class Game(val secretNumber: Int) {
    var attempts = 0

    fun guess(number: Int): String {
        return when {
            (number < secretNumber) -> {
                attempts++
                "Больше"
            }
            (number > secretNumber) -> {
                attempts++
                "Меньше"
            }
            else -> "Угадал!"
        }
    }

    fun getAttemptCount(): Int {
        return attempts
    }
}

fun main() {
    val secretNumber = Random.nextInt(1, 21)
    val game = Game(secretNumber)

    while (true) {
        print("Введите число: ")
        val number = readln().toInt()
        val result = game.guess(number)
        println(result)
        if (result == "Угадал!") break
    }
    println("Количество попыток: ${game.getAttemptCount()}")
}