package comboCode

import kotlin.random.Random

fun main() {
    val letter = getRandomLetter()
    println(letter)
}

fun getRandomLetter(): Char {
    val lowercase = ('a'..'z').toList()
    val randomIndex = Random.nextInt(lowercase.size)
    return lowercase[randomIndex]
}