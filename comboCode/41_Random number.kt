package comboCode

import kotlin.random.Random

fun main() {
    val number = getRandomNumber()
    println(number)
}

fun getRandomNumber(): Int {
    val input = (1..100).toList()
    val randomNumber = Random.nextInt(input.size)
    return input[randomNumber]
}