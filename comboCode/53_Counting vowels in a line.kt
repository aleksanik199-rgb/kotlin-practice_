package comboCode

import kotlin.text.lowercase

fun main() {
    print("Введите текст: ")
    val text = readln()


    val count = countVowels(text)

    println("Колличество гласных букв: $count")
}

fun countVowels(text: String): Int {
    var glossaryLetters = 0
    for(ch in text.lowercase()) {
        if(ch in "аеёиоуыэюя" || ch in "aeiouy") {
            glossaryLetters++
        }
    }
    return glossaryLetters
}